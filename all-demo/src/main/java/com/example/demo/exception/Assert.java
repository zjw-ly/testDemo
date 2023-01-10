package com.example.demo.exception;

import java.util.Collection;
import java.util.Map;

/**
 * 断言
 *
 * @author zaochun.zjw
 * @date 2022/8/25
 */
public class Assert {

    /**
     * 断言表达式后的结果是true，否则抛出异常信息
     *
     * @param expression   表达式结果
     * @param errorCode    错误码
     * @param errorMessage 错误提示
     */
    public static void isTrue(boolean expression, String errorCode, String errorMessage) {
        if (!expression) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    /**
     * 断言表达式后的结果是true，否则抛出异常信息
     *
     * @param expression   表达式结果
     * @param errorMessage 错误提示
     */
    public static void isTrue(boolean expression, String errorMessage) {
        if (!expression) {
            throw new BizException(errorMessage);
        }
    }

    /**
     * 断言执行表达式后的结果是 true，否则抛出业务异常信息
     *
     * @param expression    表达式
     * @param baseErrorCode 错误码
     */
    public static void isTrue(boolean expression, BaseErrorCode baseErrorCode) {
        if (!expression) {
            throw new BizException(baseErrorCode);
        }
    }

    /**
     * 断言执行表达式后的结果是 false，否则抛出业务异常信息
     *
     * @param expression   表达式
     * @param errorCode    错误码
     * @param errorMessage 错误提示
     */
    public static void isFalse(boolean expression, String errorCode, String errorMessage) {
        if (expression) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    /**
     * 断言执行表达式后的结果是 false，否则抛出业务异常信息
     *
     * @param expression   表达式
     * @param errorMessage 错误提示
     */
    public static void isFalse(boolean expression, String errorMessage) {
        if (expression) {
            throw new BizException(errorMessage);
        }
    }

    /**
     * 断言执行表达式后的结果是 false，否则抛出业务异常信息
     *
     * @param expression    表达式
     * @param baseErrorCode 错误码
     */
    public static void isFalse(boolean expression, BaseErrorCode baseErrorCode) {
        if (expression) {
            throw new BizException(baseErrorCode);
        }
    }

    /**
     * 断言传入的对象不是 null，否则抛出业务异常信息
     *
     * @param object       对象
     * @param errorCode    错误码
     * @param errorMessage 错误提示
     */
    public static void notNull(Object object, String errorCode, String errorMessage) {
        if (null == object) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    /**
     * 断言传入的对象不是 null，否则抛出业务异常信息
     *
     * @param object       对象
     * @param errorMessage 错误提示
     */
    public static void notNull(Object object, String errorMessage) {
        if (null == object) {
            throw new BizException(errorMessage);
        }
    }

    /**
     * 断言传入的对象不是 null，否则抛出业务异常信息
     *
     * @param object        对象
     * @param baseErrorCode 错误码
     */
    public static void notNull(Object object, BaseErrorCode baseErrorCode) {
        if (null == object) {
            throw new BizException(baseErrorCode);
        }
    }

    /**
     * 断言传入的集合不为空，否则抛出业务异常信息
     *
     * @param collection   集合
     * @param errorCode    错误码
     * @param errorMessage 错误提示
     */
    public static void notEmpty(Collection<?> collection, String errorCode, String errorMessage) {
        if (null == collection || collection.isEmpty()) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    /**
     * 断言传入的集合不为空，否则抛出业务异常信息
     *
     * @param collection   集合
     * @param errorMessage 错误提示
     */
    public static void notEmpty(Collection<?> collection, String errorMessage) {
        if (null == collection || collection.isEmpty()) {
            throw new BizException(errorMessage);
        }
    }

    /**
     * 断言传入的集合不为空，否则抛出业务异常信息
     *
     * @param collection    集合
     * @param baseErrorCode 错误码
     */
    public static void notEmpty(Collection<?> collection, BaseErrorCode baseErrorCode) {
        if (null == collection || collection.isEmpty()) {
            throw new BizException(baseErrorCode);
        }
    }

    /**
     * 断言传入的集合不为空，否则抛出业务异常信息
     *
     * @param map          集合
     * @param errorCode    错误码
     * @param errorMessage 错误提示
     */
    public static void notEmpty(Map<?, ?> map, String errorCode, String errorMessage) {
        if (null == map || map.isEmpty()) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    /**
     * 断言传入的集合不为空，否则抛出业务异常信息
     *
     * @param map          集合
     * @param errorMessage 错误提示
     */
    public static void notEmpty(Map<?, ?> map, String errorMessage) {
        if (null == map || map.isEmpty()) {
            throw new BizException(errorMessage);
        }
    }

    /**
     * 断言传入的集合不为空，否则抛出业务异常信息
     *
     * @param map           集合
     * @param baseErrorCode 错误码
     */
    public static void notEmpty(Map<?, ?> map, BaseErrorCode baseErrorCode) {
        if (null == map || map.isEmpty()) {
            throw new BizException(baseErrorCode);
        }
    }

    /**
     * 断言传入的数组不为空，否则抛出业务异常信息
     *
     * @param array        数组
     * @param errorCode    错误码
     * @param errorMessage 错误提示
     */
    public static void notEmpty(Object[] array, String errorCode, String errorMessage) {
        if (null == array || array.length < 1) {
            throw new BizException(errorCode, errorMessage);
        }
    }

    /**
     * 断言传入的数组不为空，否则抛出业务异常信息
     *
     * @param array        数组
     * @param errorMessage 错误提示
     */
    public static void notEmpty(Object[] array, String errorMessage) {
        if (null == array || array.length < 1) {
            throw new BizException(errorMessage);
        }
    }

    /**
     * 断言传入的数组不为空，否则抛出业务异常信息
     *
     * @param array         数组
     * @param baseErrorCode 错误码
     */
    public static void notEmpty(Object[] array, BaseErrorCode baseErrorCode) {
        if (null == array || array.length < 1) {
            throw new BizException(baseErrorCode);
        }
    }
}
