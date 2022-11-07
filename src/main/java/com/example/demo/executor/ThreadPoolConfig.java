package com.example.demo.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * 线程池配置
 *
 * @author zaochun.zjw
 * @date 2022/8/24
 */
public class ThreadPoolConfig implements AsyncConfigurer {

    ThreadFactory springThreadFactory = new CustomizableThreadFactory("alihealth-Thread-pool-");

    private static final int MAX_POOL_SIZE = 20;

    private static final int CORE_POOL_SIZE = 10;

    private static final int QUEUE_SIZE = 200;

    @Override
    @Bean("asyncExecutor")
    public ExecutorService getAsyncExecutor() {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 60L,
                                                                    TimeUnit.SECONDS, queue,springThreadFactory);
        return executorService;
    }
}
