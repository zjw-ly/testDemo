package com.example.demo.generate.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解识别类型
 *
 * @author zaochun.zjw
 * @date 2022/11/28
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateClassName {

    /** 类名 */
    String name() default "";
}
