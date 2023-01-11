package com.example.demo.commons;

/**
 * @author fuxi@cainiao.com
 * @date 2020/6/6
 **/

public class RpcException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public RpcException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
