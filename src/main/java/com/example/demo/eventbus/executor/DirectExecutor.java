package com.example.demo.eventbus.executor;

import java.util.concurrent.Executor;

/**
 * runnable.run,使用顺序执行的方法调度
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public class DirectExecutor implements Executor {

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
