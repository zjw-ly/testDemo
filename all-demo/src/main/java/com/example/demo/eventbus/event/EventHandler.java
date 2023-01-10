package com.example.demo.eventbus.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 事件处理函数注解，标记当前方法是一个事件处理函数
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {

    /**
     * 事件描述
     *
     * @return 事件描述
     */
    String name();
}
