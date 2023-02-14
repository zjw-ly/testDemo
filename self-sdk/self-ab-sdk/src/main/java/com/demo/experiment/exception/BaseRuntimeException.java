package com.demo.experiment.exception;

/**
 * 异常
 *
 * @author hengyue.qhy
 * @date 2022-08-05
 */
public abstract class BaseRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorCode;

    public BaseRuntimeException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public BaseRuntimeException(String errorCode, String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}

