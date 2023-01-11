package com.example.demo.registry;

/**
 * 服务治理
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
public interface ServiceRegistry {

    /**
     * 服务注册
     *
     * @param serviceMetadata 服务元数据
     */
    void register(ServiceMetadata serviceMetadata) throws Exception;

    /**
     * 服务注销
     *
     * @param serviceMetadata 服务元数据
     */
    void unRegister(ServiceMetadata serviceMetadata) throws Exception;

    /**
     * 服务发现
     *
     * @param serviceName 服务名
     * @return 返回服务发现结果
     */
    ServiceMetadata discovery(String serviceName) throws Exception;

    /**
     * 关闭服务
     */
    void close() throws Exception;
}
