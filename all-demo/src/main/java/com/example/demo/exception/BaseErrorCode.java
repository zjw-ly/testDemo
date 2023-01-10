package com.example.demo.exception;

/**
 * 错误码
 *
 * @author zaochun.zjw
 * @date 2022/8/25
 */
public interface BaseErrorCode {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    String getErrorCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getErrorMessage();
}
