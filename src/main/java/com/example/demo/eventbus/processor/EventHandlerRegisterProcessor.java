package com.example.demo.eventbus.processor;

import com.example.demo.eventbus.EventBus;
import com.example.demo.eventbus.event.EventHandler;
import com.example.demo.eventbus.util.ProxyUtils;
import com.example.demo.eventbus.util.ReflectUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 事件处理函数注册 - 扫描注册初始化后的bean对象，将满足条件的注册到容器当中执行分发。
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
@Order(111)
public class EventHandlerRegisterProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    //bean初始化完成之后都要调用 -> 这里适合穿插逻辑在spring bean初始化完成之后处理 （@Order代表执行顺序）
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        register(bean);

        return bean;
    }
    /**
     * 注册Bean方法到总线
     *
     * @param bean bean
     */
    private void register(Object bean) {
        final Object listener = ProxyUtils.getTarget(bean);

        List<Method> methodList = ReflectUtils.getMethodList(listener);
        if (methodList.size() < 1) {
            return;
        }

        boolean hasEventHandlerAnnotation = false;
        for (Method method : methodList) {
            if (ReflectUtils.isAnnotationPresent(method, EventHandler.class)) {
                hasEventHandlerAnnotation = true;

                break;
            }
        }

        if (!hasEventHandlerAnnotation) {
            return;
        }

        EventBus.register(listener);
    }
}
