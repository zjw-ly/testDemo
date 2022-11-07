package com.example.demo.eventbus.executor;

/**
 * 执行器工厂
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public class ExecutorFactory {

    /**
     * 创建直接运行执行器
     *
     * @return 直接运行执行器
     */
    public static DirectExecutor createDirectorExecutor() {
        return new DirectExecutor();
    }

    /**
     * 创建akka异步执行器
     *
     * @return akka异步执行器
     */
    public static AkkaExecutor createAkkaExecutor() {
        return new AkkaExecutor();
    }
}
