package com.example.demo.provider;

import com.example.demo.annotation.RPCProvider;
import com.example.demo.commons.ProviderUtils;
import com.example.demo.protocol.RpcDecoder;
import com.example.demo.protocol.RpcEncoder;
import com.example.demo.registry.ServiceMetadata;
import com.example.demo.registry.ServiceRegistry;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import lombok.extern.slf4j.Slf4j;
import netscape.security.UserTarget;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.example.demo.constants.Constants.PROVIDER_THREAD_POOL_NUM;
import static com.example.demo.constants.Constants.PROVIDER_THREAD_POOL_QUEUE_LEN;

/**
 * 服务提供者
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
@Slf4j
public class RpcProvider implements InitializingBean, BeanPostProcessor {

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("rpc-provider-pool-%d").build();

    private static ThreadPoolExecutor threadPoolExecutor;

    /** 服务地址 */
    private String serverAddress;

    /** 服务注册中心 -> 服务 */
    private ServiceRegistry serviceRegistry;

    /** 处理器 */
    private Map<String, Object> handlerMap = new HashMap<>(256);

    private EventLoopGroup boosGroup = null;

    private EventLoopGroup workerGroup = null;

    public RpcProvider(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public RpcProvider(String serverAddress, ServiceRegistry serviceRegistry) {
        this.serverAddress = serverAddress;
        this.serviceRegistry = serviceRegistry;
    }

    public static void submit(Runnable task) {
        if (threadPoolExecutor == null) {
            synchronized (RpcProvider.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = new ThreadPoolExecutor(
                        PROVIDER_THREAD_POOL_NUM,
                        PROVIDER_THREAD_POOL_NUM,
                        600L,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(PROVIDER_THREAD_POOL_QUEUE_LEN),
                        threadFactory
                    );
                }
            }
        }

        threadPoolExecutor.submit(task);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(()->{
            try{
                startListener();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 开始监听
     *
     * @throws InterruptedException 中断异常
     */
    public void startListener() throws InterruptedException {
        if(boosGroup == null || workerGroup == null){
            boosGroup = new NioEventLoopGroup();
            workerGroup = new NioEventLoopGroup();

            //一个 Netty 应用通常由一个 Bootstrap 开始，其主要作用是配置整个 Netty 程序，串联各个组件，
            // Netty 中 Bootstrap 类是客户端程序的启动引导类，ServerBootstrap 是服务端启动引导类。
            ServerBootstrap bootstrap = new ServerBootstrap();
            //通用平台使用NioServerSocketChannel，Linux使用EpollServerSocketChannel
            bootstrap.group(boosGroup,workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline()
                            .addLast(new LengthFieldBasedFrameDecoder(65536, 0, 4, 0, 0))
                            .addLast(new RpcDecoder())
                            .addLast(new RpcEncoder())
                            .addLast(new RpcProviderHandler(handlerMap));
                    }
                })                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);

            String[] array = serverAddress.split(":");
            String host = array[0];
            int port = Integer.parseInt(array[1]);

            //启动服务
            ChannelFuture future = bootstrap.bind(host, port).sync();

            future.channel().closeFuture().sync();
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    //在所有bean初始化完成后执行此方法， 会将RPCProvider标识的类存入到handler的map中
    @Override
    public Object postProcessAfterInitialization(Object bean,String beanName) {
        RPCProvider rpcProvider = bean.getClass().getAnnotation(RPCProvider.class);
        if (rpcProvider == null) {
            return bean;
        }
        String serviceName = rpcProvider.serviceInterface().getName();
        String version = rpcProvider.serviceVersion();
        String providerKey = ProviderUtils.makeKey(serviceName, version);
        //缓存provider bean到本地缓存中
        handlerMap.put(providerKey, bean);

        // 注册服务到注册中心
        String[] array = serverAddress.split(":");
        //地址
        String host = array[0];
        //端口
        int port = Integer.parseInt(array[1]);
        ServiceMetadata metadata = ServiceMetadata.builder()
            .address(host)
            .serviceName(serviceName)
            .port(port)
            .serviceVersion(version).build();
        try {
            //将对应的元数据 注册到注册中心中
            serviceRegistry.register(metadata);
            log.debug("register service: {}", metadata.toString());
        } catch (Exception e) {
            log.error("register service fail|{}|{}", metadata.toString(), e);
        }
        return bean;
    }
}