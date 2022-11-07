package com.example.demo.eventbus.exception;

/**
 * bus方法调用异常
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public class BusInvokerException extends RuntimeException{

    public BusInvokerException(){
    }

    public BusInvokerException(Throwable cause){
        super(cause);
    }
}
