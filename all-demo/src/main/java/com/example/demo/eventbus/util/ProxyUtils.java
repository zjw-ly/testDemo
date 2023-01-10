package com.example.demo.eventbus.util;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Field;

/**
 * 代理工具类
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public class ProxyUtils {

    /**
     * 获取代理的目标对象
     *
     * @param proxy 代理对象
     * @return 真实对象
     */
    public static Object getTarget(Object proxy) {

        // 不是代理对象
        if (!AopUtils.isAopProxy(proxy)) {
            return proxy;
        }

        // 是jdk动态代理
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            try {
                return getJdkDynamicProxyTargetObject(proxy);
            } catch (Exception e) {
                return proxy;
            }
        }

        try {
            return getCglibProxyTargetObject(proxy);
        } catch (Exception e) {
            return proxy;
        }
    }

    /**
     * CGLib代理对象
     *
     * @param proxy 代理对象
     * @return 真实对象
     * @throws Exception
     */
    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(proxy);
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        return ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
    }

    /**
     * JDK代理对象
     *
     * @param proxy 代理对象
     * @return 真实对象
     * @throws Exception 异常
     */
    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);
        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        return ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();
    }
}
