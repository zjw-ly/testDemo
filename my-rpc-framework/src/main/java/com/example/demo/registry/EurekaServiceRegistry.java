package com.example.demo.registry;

/**
 * eureka服务
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
public class EurekaServiceRegistry implements ServiceRegistry{

    public EurekaServiceRegistry(String address) {
    }

    @Override
    public void register(ServiceMetadata serviceMetadata) {

    }

    @Override
    public void unRegister(ServiceMetadata serviceMetadata) {

    }

    @Override
    public ServiceMetadata discovery(String serviceName) {
        return null;
    }

    @Override
    public void close() {

    }
}
