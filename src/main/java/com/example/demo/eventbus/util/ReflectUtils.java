package com.example.demo.eventbus.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 反射工具类
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public class ReflectUtils {

    /**
     * 获取当前类与父类的所有方法
     *
     * @param object dui x
     * @return
     */
    public static List<Method> getMethodList(Object object) {

        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Method[] methods = clazz.getMethods();

                return Arrays.asList(methods);
            } catch (Exception e) {
                throw new RuntimeException("EventRegistry#getMethodList error, object is " + object);
            }
        }

        return new ArrayList<>(0);
    }

    /**
     * 是否有EventHandler注解标记
     *
     * @param method     方法
     * @param annotation 注解标记
     * @return 是否有EventHandler注解标记
     */
    public static boolean isAnnotationPresent(Method method, Class<? extends Annotation> annotation) {
        return method.isAnnotationPresent(annotation);
    }
}
