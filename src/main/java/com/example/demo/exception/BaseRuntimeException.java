package com.example.demo.exception;

import lombok.Data;

/**
 * 自定义运行时异常
 *
 * @author zaochun.zjw
 * @date 2022/8/25
 */
@Data
public abstract class BaseRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorCode;

    /**
     * 自定义运行时异常
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     */
    public BaseRuntimeException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    /**
     * 自定义运行时异常
     *
     * @param baseErrorCode 错误码
     */
    public BaseRuntimeException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode.getErrorMessage());
        this.errorCode = baseErrorCode.getErrorCode();
    }

    /**
     * 自定义运行时异常
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @param e            异常堆栈
     */
    public BaseRuntimeException(String errorCode, String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorCode = errorCode;
    }

    /**
     * 自定义运行时异常
     *
     * @param baseErrorCode 错误码
     * @param e             异常堆栈
     */
    public BaseRuntimeException(BaseErrorCode baseErrorCode, Throwable e) {
        super(baseErrorCode.getErrorMessage(), e);
        this.errorCode = baseErrorCode.getErrorCode();
    }
}
