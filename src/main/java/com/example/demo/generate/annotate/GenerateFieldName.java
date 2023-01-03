package com.example.demo.generate.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 识别字段名称
 *
 * @author zaochun.zjw
 * @date 2022/11/28
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateFieldName {

    /** 字段显示名称 */
    String name() default "";

    /** 值为null 时 字段是否展示 */
    boolean isNullShow() default false;

    /** 是否需要递归 */
    boolean isRecursive() default false;
}
