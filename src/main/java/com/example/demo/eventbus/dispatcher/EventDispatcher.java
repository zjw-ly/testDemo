package com.example.demo.eventbus.dispatcher;

import com.example.demo.eventbus.invoker.Invoker;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;

/**
 * 事件分发器
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public final class EventDispatcher {

    /**
     * 线程执行器
     */
    private final Executor executor;

    /**
     * 构造执行器
     *
     * @param executor 执行器
     */
    public EventDispatcher(Executor executor) {
        this.executor = executor;
    }

    /**
     * 分发事件
     *
     * @param event    事件
     * @param invokers 事件执行器
     */
    public void dispatch(final Object event, Collection<Invoker> invokers) {
        Iterator<Invoker> iterator = invokers.iterator();
        while (iterator.hasNext()) {
            final Invoker invoker = iterator.next();

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    invoker.invoke(event);
                }
            });
        }
    }
}
