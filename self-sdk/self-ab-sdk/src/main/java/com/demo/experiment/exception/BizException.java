package com.demo.experiment.exception;

/**
 * 异常
 *
 * @author hengyue.qhy
 * @date 2022-08-05
 */
public class BizException extends BaseRuntimeException {

    public static final String ERROR_CODE_DEFAULT = "ERROR";

    private static final long serialVersionUID = 1L;

    public BizException(String errorMessage) {
        super(ERROR_CODE_DEFAULT, errorMessage);
    }

    public BizException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public BizException(String errorMessage, Throwable e) {
        super(ERROR_CODE_DEFAULT, errorMessage, e);
    }

    public BizException(String errorCode, String errorMessage, Throwable e) {
        super(errorCode, errorMessage, e);
    }
}