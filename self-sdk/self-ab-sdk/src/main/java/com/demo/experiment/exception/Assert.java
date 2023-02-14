package com.demo.experiment.exception;

import java.util.Collection;
import java.util.Map;

/**
 * 异常
 *
 * @author hengyue.qhy
 * @date 2022-08-05
 */
public class Assert {

    public Assert() {
    }

    public static void isTrue(boolean expression, String errorCode, String errorMessage) {
        if (!expression) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    public static void isTrue(boolean expression, String errorMessage) {
        if (!expression) {
            throw new BizException(errorMessage);
        }
    }

    public static void isFalse(boolean expression, String errorCode, String errorMessage) {
        if (expression) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    public static void isFalse(boolean expression, String errorMessage) {
        if (expression) {
            throw new BizException(errorMessage);
        }
    }

    public static void notNull(Object object, String errorCode, String errorMessage) {
        if (null == object) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    public static void notNull(Object object, String errorMessage) {
        if (null == object) {
            throw new BizException(errorMessage);
        }
    }

    public static void notEmpty(Collection<?> collection, String errorCode, String errorMessage) {
        if (null == collection || collection.isEmpty()) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    public static void notEmpty(Collection<?> collection, String errorMessage) {
        if (null == collection || collection.isEmpty()) {
            throw new BizException(errorMessage);
        }
    }

    public static void notEmpty(Map<?, ?> map, String errorCode, String errorMessage) {
        if (null == map || map.isEmpty()) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    public static void notEmpty(Map<?, ?> map, String errorMessage) {
        if (null == map || map.isEmpty()) {
            throw new BizException(errorMessage);
        }
    }

    public static void notEmpty(Object[] array, String errorCode, String errorMessage) {
        if (null == array || array.length < 1) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    public static void notEmpty(Object[] array, String errorMessage) {
        if (null == array || array.length < 1) {
            throw new BizException(errorMessage);
        }
    }
}
