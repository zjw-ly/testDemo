package com.example.demo.eventbus.registry;

import com.example.demo.eventbus.event.Event;
import com.example.demo.eventbus.event.EventHandler;
import com.example.demo.eventbus.invoker.Invoker;
import com.example.demo.eventbus.util.ReflectUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 方法执行器注册中心
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public final class EventRegistry {

    /** Event执行器、key是事件类型，value是执行器集合 */
    private static final Map<Class<? extends Event>, CopyOnWriteArraySet<Invoker>> EVENT_INVOKERS = new ConcurrentHashMap<>(16);

    /** 监听器集合，防止重复注册 */
    private static final Set<Class<?>> LISTENER_SET = new HashSet<>();

    private EventRegistry() {
    }

    /**
     * 注册监听器
     *
     * @param listener 监听器
     */
    public static void register(Object listener) {
        final Class<?> listenerClass = listener.getClass();
        if (LISTENER_SET.contains(listenerClass)) {
            return;
        }

        synchronized (EventRegistry.class) {

            if (LISTENER_SET.contains(listenerClass)) {
                return;
            }

            Map<Class<? extends Event>, CopyOnWriteArraySet<Invoker>> methodInvokers = getMethodInvokers(listener);
            for (Map.Entry<Class<? extends Event>, CopyOnWriteArraySet<Invoker>> entry : methodInvokers.entrySet()) {
                Class<? extends Event> eventClass = entry.getKey();
                CopyOnWriteArraySet<Invoker> invokers = entry.getValue();

                CopyOnWriteArraySet<Invoker> allInvokers = EVENT_INVOKERS.get(eventClass);
                if (allInvokers == null) {
                    allInvokers = new CopyOnWriteArraySet<Invoker>();
                }

                allInvokers.addAll(invokers);

                EVENT_INVOKERS.put(eventClass, allInvokers);
            }

            LISTENER_SET.add(listenerClass);
        }
    }

    /**
     * 获取方法执行器
     *
     * @param event 事件
     * @return 方法执行器
     */
    public static Set<Invoker> getInvokers(Event event) {
        CopyOnWriteArraySet<Invoker> invokers = EVENT_INVOKERS.get(event.getClass());

        return invokers == null ? new CopyOnWriteArraySet<>() : invokers;
    }

    /**
     * 获取事件监听器中所有的事件处理函数
     *
     * @param listener 监听器
     * @return 事件监听器中所有的事件处理函数
     */
    private static Map<Class<? extends Event>, CopyOnWriteArraySet<Invoker>> getMethodInvokers(Object listener) {
        Map<Class<? extends Event>, CopyOnWriteArraySet<Invoker>> result = new HashMap<>(16);
        List<Method> methodList = ReflectUtils.getMethodList(listener);

        for (Method method : methodList) {

            // 1.判断方法上是否有 @EventHandler 注解 没有则跳过
            if (!ReflectUtils.isAnnotationPresent(method, EventHandler.class)) {
                continue;
            }

            // 2.获取方法入参，验证是否只有一个参数
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != 1) {
                throw new IllegalArgumentException("Method " + method + " has @EventHandler annotation, but subscriber methods must require a single argument");
            }

            // 3.获取参数类型
            Class<?> parameterType = parameterTypes[0];
            if (!Event.class.isAssignableFrom(parameterType)) {
                throw new IllegalArgumentException("ParameterType " + parameterType + " is not extend com.alibaba.deer.cqrs.event.Event");
            }

            // 4.根据事件类型，获取该方法的所有方法执行器，没有则新建
            CopyOnWriteArraySet<Invoker> invokers = result.get(parameterType);
            if (invokers == null) {
                invokers = new CopyOnWriteArraySet<>();
            }

            // 5.获取事件处理函数描述
            EventHandler handler = method.getAnnotation(EventHandler.class);
            String handlerName = handler.name();

            // 6.添加到方法执行器集合
            invokers.add(new Invoker(listener, method, handlerName));

            result.put((Class<? extends Event>) parameterType, invokers);
        }

        return result;
    }
}
