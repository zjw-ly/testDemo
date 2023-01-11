package com.example.demo.registry;

import com.example.demo.commons.ProviderUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.x.discovery.*;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.apache.curator.x.discovery.strategies.RoundRobinStrategy;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * zookeeper服务
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
@Slf4j
public class ZookeeperServiceRegistry implements ServiceRegistry {

    private final CuratorFramework client;

    private final Object lock = new Object();

    private final ServiceDiscovery<ServiceMetadata> serviceDiscovery;

    /** 服务提供的 本地缓存，避免不必要的请求 */
    private final Map<String, ServiceProvider<ServiceMetadata>> serviceProviderCache;

    /** 可关闭的服务提供者 */
    private final List<Closeable> closeableProviders = Lists.newArrayList();

    /**
     * 初始化zookeeper服务中心
     *
     * @param address 服务地址
     */
    public ZookeeperServiceRegistry(String address) throws Exception {
        serviceProviderCache = new ConcurrentHashMap<>(256);
        //1.使用默认会话超时、默认连接超时配置创建新客户端
        this.client = CuratorFrameworkFactory.newClient(address, new ExponentialBackoffRetry(1000, 3));
        this.client.start();

        JsonInstanceSerializer<ServiceMetadata> serializer = new JsonInstanceSerializer<>(ServiceMetadata.class);
        serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceMetadata.class)
            .client(this.client)
            .serializer(serializer)
            .build();

        serviceDiscovery.start();
    }

    @Override
    public void register(ServiceMetadata serviceMetadata) throws Exception {
        ServiceInstance<ServiceMetadata> serviceInstance = ServiceInstance
            .<ServiceMetadata>builder()
            .name(ProviderUtils.makeKey(serviceMetadata.getServiceName(), serviceMetadata.getServiceVersion()))
            .address(serviceMetadata.getAddress())
            .port(serviceMetadata.getPort())
            .payload(serviceMetadata)
            .uriSpec(new UriSpec("{scheme}://{address}:{port}"))
            .build();

        serviceDiscovery.registerService(serviceInstance);
    }

    @Override
    public void unRegister(ServiceMetadata serviceMetadata) throws Exception {
        ServiceInstance<ServiceMetadata> serviceInstance = ServiceInstance
            .<ServiceMetadata>builder()
            .name(serviceMetadata.getServiceName())
            .address(serviceMetadata.getAddress())
            .port(serviceMetadata.getPort())
            .payload(serviceMetadata)
            .uriSpec(new UriSpec("{scheme}://{address}:{port}"))
            .build();

        serviceDiscovery.unregisterService(serviceInstance);
    }

    @Override
    public ServiceMetadata discovery(String serviceName) throws Exception {
        ServiceProvider<ServiceMetadata> serviceProvider = serviceProviderCache.get(serviceName);

        if (null == serviceProvider) {
            synchronized (lock) {
                serviceProvider = serviceDiscovery
                    .serviceProviderBuilder()
                    .serviceName(serviceName)
                    //负载均衡策略
                    .providerStrategy(new RoundRobinStrategy<>())
                    .build();

                serviceProvider.start();
                closeableProviders.add(serviceProvider);
                serviceProviderCache.put(serviceName, serviceProvider);
            }
        }

        ServiceInstance<ServiceMetadata> serviceInstance = serviceProvider.getInstance();
        return serviceInstance != null ? serviceInstance.getPayload() : null;
    }

    @Override
    public void close() throws Exception {
        for(Closeable closeable:closeableProviders){
            CloseableUtils.closeQuietly(closeable);
        }

        serviceDiscovery.close();
    }
}
