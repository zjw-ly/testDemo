package com.example.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务提供者
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Autowired
public @interface RPCProvider {

    Class<?> serviceInterface() default Object.class;

    String serviceVersion() default "1.0.0";
}
