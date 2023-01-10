package com.example.demo.eventbus;

import com.example.demo.eventbus.dispatcher.EventDispatcher;
import com.example.demo.eventbus.event.Event;
import com.example.demo.eventbus.executor.ExecutorFactory;
import com.example.demo.eventbus.invoker.Invoker;
import com.example.demo.eventbus.registry.EventRegistry;

import java.util.Set;

/**
 * 事件总线 - (spring的bean注册的实际调用方法、handler调用执行事件分发都是从这里开始、)
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public final class EventBus {

    /** 创建同步分发器 */
    private static final EventDispatcher EVENT_DISPATCHER = new EventDispatcher(ExecutorFactory.createDirectorExecutor());

    /** 创建异步分发器 */
    private static final EventDispatcher ASYNC_EVENT_DISPATCHER = new EventDispatcher(ExecutorFactory.createAkkaExecutor());

    private EventBus() {
    }

    /**
     * 注册监听器
     *
     * @param listener 监听器
     */
    public static void register(Object listener) {
        EventRegistry.register(listener);
    }

    /**
     * 事件分发
     *
     * @param event 事件
     */
    public static void dispatch(Event event) {
        dispatch(event, EVENT_DISPATCHER);
    }

    /**
     * 异步事件分发
     *
     * @param event 事件
     */
    public static void dispatchAsync(Event event) {
        dispatch(event, ASYNC_EVENT_DISPATCHER);
    }

    /**
     * 内部事件分发
     *
     * @param event      事件
     * @param dispatcher 事件分发器
     */
    private static void dispatch(Event event, EventDispatcher dispatcher) {
        Set<Invoker> invokers = EventRegistry.getInvokers(event);

        dispatcher.dispatch(event, invokers);
    }
}
