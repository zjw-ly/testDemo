package com.example.demo.generate.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解识别方法名称
 *
 * @author zaochun.zjw
 * @date 2022/11/28
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateMethodName {

    /** 方法调用 - markDown标题 */
    String title() default "";
}
