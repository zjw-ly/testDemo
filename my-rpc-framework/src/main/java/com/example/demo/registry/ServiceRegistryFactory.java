package com.example.demo.registry;

/**
 * 服务注册工厂
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
public class ServiceRegistryFactory {

    private static volatile ServiceRegistry serviceRegistry;

    public static ServiceRegistry getInstance(ServiceRegistryType type,String registryAddress) throws Exception {

        if(null == serviceRegistry){
            synchronized (ServiceRegistryFactory.class){
                if(null == serviceRegistry){
                    serviceRegistry = type == ServiceRegistryType.zookeeper ? new ZookeeperServiceRegistry(registryAddress) :
                        type == ServiceRegistryType.eureka ? new EurekaServiceRegistry(registryAddress) : null;
                }
            }
        }

        return serviceRegistry;
    }
}
