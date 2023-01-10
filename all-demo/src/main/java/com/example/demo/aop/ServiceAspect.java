package com.example.demo.aop;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author zaochun.zjw
 * @date 2022/10/26
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceAspect {

    String value()default "";

    /**
     * 请求参数类型实例
     *
     * @return
     */
    Class requestType();

    /**
     * 返回结果类型实例子
     *
     * @return
     */
    Class responseType();
}
