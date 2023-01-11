package com.example.demo.constants;

/**
 * 生产者队列
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
public class Constants {

    public static final String DEFAULT_HOST = "127.0.0.1";

    public static final int DEFAULT_PORT = 8080;

    /**
     * init method name
     */
    public static String INIT_METHOD = "init";

    /**
     * 生产者线程池线程数量
     */
    public static final int PROVIDER_THREAD_POOL_NUM = 256;

    /**
     * 生产者线程池工作队列长度
     */
    public static final int PROVIDER_THREAD_POOL_QUEUE_LEN = 1024;

    /**
     * 注册中心root节点名
     */
    public static final String BASE_PATH = "/rpc";
}
