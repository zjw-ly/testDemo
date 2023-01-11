package com.example.demo.provider;

import com.example.demo.commons.RpcProperties;
import com.example.demo.registry.ServiceRegistry;
import com.example.demo.registry.ServiceRegistryFactory;
import com.example.demo.registry.ServiceRegistryType;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 自动配置类 -> 这里用自动配置类 首先会将在读取配置文件的信息、然后将RpcProvider类交由spring容器管理，
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
@Configuration
@EnableConfigurationProperties(RpcProperties.class)
public class RpcProviderAutoConfiguration {

    @Resource
    private RpcProperties rpcProperties;

    @Bean
    public RpcProvider init() throws Exception {
        //这里在初始化时，会读取RpcProperties 配置文件的配置
        ServiceRegistryType type = ServiceRegistryType.valueOf(rpcProperties.getServiceRegistryType());
        ServiceRegistry serviceRegistry = ServiceRegistryFactory.getInstance(type, rpcProperties.getServiceRegistryAddress());

        return new RpcProvider(rpcProperties.getServiceAddress(), serviceRegistry);
    }
}
