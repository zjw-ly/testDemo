package com.example.demo.eventbus.invoker;

import com.example.demo.eventbus.exception.BusInvokerException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 方法执行器
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public class Invoker {

    /** 监听器 */
    private final Object listener;

    /** 监听的方法 */
    private final Method method;

    /** 名称 */
    private final String name;

    public Invoker(Object listener,Method method,String name){
        this.listener = listener;
        this.method = method;
        this.name = name;

        method.setAccessible(true);
    }

    /**
     * 执行方法
     *
     * @param parameter
     * @return
     */
    public Object invoke(Object parameter){
        try{
            return method.invoke(listener,parameter);
        }catch (InvocationTargetException e){
            if (e.getCause() instanceof RuntimeException) {
                throw (RuntimeException) (e.getCause());
            } else {
                throw new BusInvokerException(e);
            }
        }catch (Throwable e){
            throw new BusInvokerException(e);
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return  true;
        }

        if(o == null ||getClass()!=o.getClass()){
            return false;
        }

        Invoker invoker = (Invoker) o;
        if(!listener.equals(invoker.listener)){
            return false;
        }

        return method.equals(invoker.method);
    }


    @Override
    public int hashCode() {
        int result = listener.hashCode();
        result = 31 * result + method.hashCode();

        return result;
    }

    public Object getListener() {
        return listener;
    }

    public Method getMethod() {
        return method;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Invoker{" +
            "listener=" + listener +
            ", method=" + method +
            ", name='" + name + '\'' +
            '}';
    }
}
