package com.example.demo.base.facade;

import com.example.demo.base.types.FacadeFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * 基础防腐层 - 核心:远程重试机制,对于远程函数
 *
 * @author zaochun.zjw
 * @date 2022/11/2
 */
public abstract class BaseFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseFacade.class);

    /**
     * 当执行时异常为指定的异常时进行重试
     *
     * @param type     指定的异常类型，弱异常是此类型则执行重试
     * @param times    重试次数
     * @param sleepMs  休眠时间，单位：毫秒
     * @param function 方法
     * @param <T>      返回值类型
     * @return 结果
     */
    public static <T> Optional<T> retryOnError(Class<? extends Throwable> type, int times, int sleepMs, FacadeFunction<Integer, T> function) {

        for (int i = 0; i < times; i++) {

            try {
                return Optional.ofNullable(function.apply(i));
            } catch (Throwable e) {
                LOGGER.warn("方法出错,错误信息为:{}, className:{},methodName:{}", e.getMessage(), function.getImplClass(), function.getImplMethodName(), e);
                if (!type.isInstance(e)) {
                    break;
                }
            }

            if (sleepMs > 0) {
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    //ignore
                }
            }

        }

        LOGGER.warn("facade请求结果为空 className:{},methodName:{}", function.getImplClass(), function.getImplMethodName());
        return Optional.empty();
    }

    /**
     * 当执行时异常为指定的异常时进行重试
     *
     * @param type     指定的异常类型，弱异常是此类型则执行重试
     * @param times    重试次数
     * @param function 方法
     * @param <T>      返回值类型
     * @return 结果
     */
    public static <T> Optional<T> retryOnError(Class<? extends Throwable> type, int times, FacadeFunction<Integer, T> function) {
        return retryOnError(type, times, 0, function);
    }

    /**
     * 当执行时异常为指定的异常时进行重试
     *
     * @param times    重试次数
     * @param function 方法
     * @param <T>      返回值类型
     * @return 结果
     */
    public static <T> Optional<T> retryOnError(int times, FacadeFunction<Integer, T> function) {
        return retryOnError(Throwable.class, times, 0, function);
    }

    /**
     * 当执行时异常为指定的异常时进行重试
     *
     * @param function 方法
     * @param <T>      返回值类型
     * @return 结果
     */
    public static <T> Optional<T> retryOnError(FacadeFunction<Integer, T> function) {
        return retryOnError(Throwable.class, 3, 0, function);
    }
}
