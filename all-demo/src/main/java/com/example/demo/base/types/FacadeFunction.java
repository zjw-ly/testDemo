package com.example.demo.base.types;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * Serializable Function
 *
 * @author zaochun.zjw
 * @date 2022/11/1
 */
public interface FacadeFunction<T, R> extends Function<T, R>, Serializable {

    /**
     * 获取默认方法
     *
     * @return method
     */
    default Method getMethod() {
        try {
            Method method = getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(Boolean.TRUE);
            return method;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * function SerializedLambda 返回序列化的执行结果
     *
     * @return SerializedLambda
     */
    default SerializedLambda getSerializedLambda() {
        try {
            Method method = getMethod();
            if (method == null) {
                return null;
            }
            //invoke 相当于把类中的方法参数化了，返回序列化的执行结果
            return (SerializedLambda) method.invoke(this);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * function ImplClass 返回执行结果的类名
     *
     * @return ImplClass
     */
    default String getImplClass() {
        SerializedLambda serializedLambda = getSerializedLambda();
        if (serializedLambda == null) {
            return null;
        }
        return serializedLambda.getImplClass();
    }

    /**
     * function Method Name 获取方法名称
     *
     * @return Method Name
     */
    default String getImplMethodName() {
        SerializedLambda serializedLambda = getSerializedLambda();
        if (serializedLambda == null) {
            return null;
        }
        String implMethodName = serializedLambda.getImplMethodName();
        int indexOf = implMethodName.indexOf("$");
        int lastIndexOf = implMethodName.lastIndexOf("$");
        if (indexOf > 0 && lastIndexOf > 0) {
            return implMethodName.substring(indexOf + 1, lastIndexOf);
        }
        return implMethodName;
    }
}
