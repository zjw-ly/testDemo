package com.example.demo.exception;

/**
 * 业务异常
 *
 * @author zaochun.zjw
 * @date 2022/8/25
 */
public class BizException extends BaseRuntimeException {

    public static final String ERROR_CODE_PREFIX = "FAIL_BIZ_";

    public static final String ERROR_CODE_DEFAULT = ERROR_CODE_PREFIX + "ERROR";

    private static final long serialVersionUID = 1L;

    /**
     * 默认-业务异常
     *
     * @param message 异常信息
     */
    public BizException(String message) {
        super(ERROR_CODE_DEFAULT, message);
    }

    /**
     * 业务异常
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     */
    public BizException(String errorCode, String errorMessage) {
        super(ERROR_CODE_PREFIX + errorCode, errorMessage);
    }

    /**
     * 业务异常
     *
     * @param baseErrorCode 错误码
     */
    public BizException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }

    /**
     * 业务异常
     *
     * @param errorMessage 异常信息
     * @param e            异常堆栈
     */
    public BizException(String errorMessage, Throwable e) {
        super(ERROR_CODE_DEFAULT, errorMessage, e);
    }

    /**
     * 业务异常
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @param e            异常
     */
    public BizException(String errorCode, String errorMessage, Throwable e) {
        super(ERROR_CODE_PREFIX + errorCode, errorMessage, e);
    }

    /**
     * 业务异常
     *
     * @param baseErrorCode 错误码
     * @param e             异常堆栈
     */
    public BizException(BaseErrorCode baseErrorCode, Throwable e) {
        super(baseErrorCode, e);
    }
}
