package com.example.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * rpc消费者注解
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Autowired
public @interface RPCConsumer {

    /**
     * 服务版本号
     * @see
     */
    String serviceVersion() default "1.0.0";

    String registryType() default "zookeeper";

    String registryAddress() default "127.0.0.1:2181";
}
