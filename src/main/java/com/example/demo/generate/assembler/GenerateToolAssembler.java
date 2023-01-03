package com.example.demo.generate.assembler;

import com.example.demo.exception.Assert;
import com.example.demo.generate.annotate.GenerateClassName;
import com.example.demo.generate.annotate.GenerateFieldName;
import com.example.demo.generate.annotate.GenerateMethodName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 工具markDown组装器
 *
 * @author zaochun.zjw
 * @date 2022/11/28
 */
public class GenerateToolAssembler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateToolAssembler.class);

    /**
     * 对象转化为markDown类型的数据
     *
     * @param t              对象
     * @param parameterTypes 参数
     * @param <T>            范形
     * @return markDown类型的数据
     */
    public static <T> String objectToString(T t, Class clazz, Class<?>... parameterTypes) {
        Assert.notNull(t, "CONVERTER_MARKDOWN_DATA_IS_NULL", "数据为空，转化markdown格式失败");

        //获取元方法
        Method method = getMethod(clazz, parameterTypes);

        //设置markDown标题
        StringBuilder res = setResTitle(method);

        //获取全部信息
        getFields(res, t);

        return res.toString();
    }

    /**
     * list转化为markDown类型的数据
     *
     * @param list           列表
     * @param clazz          类
     * @param parameterTypes 参数
     * @param <T>
     * @return markDown类型的数据
     */
    public static <T> String listToString(List<T> list, Class clazz, Class<?>... parameterTypes) {
        Assert.notEmpty(list, "CONVERTER_MARKDOWN_DATA_IS_NULL", "数据为空，转化markdown格式失败");

        //获取元方法
        Method method = getMethod(clazz, parameterTypes);

        //获取markDown标题
        StringBuilder res = setResTitle(method);

        //获取全部信息
        list = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
        for (T obj : list) {
            GenerateClassName className = obj.getClass().getAnnotation(GenerateClassName.class);
            if (Objects.nonNull(className)) {
                res.append(String.format("**%s信息详情:** \n\n", className.name()));
            }

            getFields(res, obj);
        }

        return res.toString();
    }

    /**
     * 获取元方法
     *
     * @param parameterTypes 参数列表
     * @return
     * @throws NoSuchMethodException
     */
    private static Method getMethod(Class clazz, Class<?>... parameterTypes) {
        Thread thread = Thread.currentThread();
        //栈桢 获取 -》 元方法
        StackTraceElement[] stackTrace = thread.getStackTrace();
        StackTraceElement stackTraceElement = null;
        if (stackTrace.length > 3 && Objects.nonNull(stackTrace[3])) {
            stackTraceElement = stackTrace[3];
        }

        Assert.notNull(stackTraceElement, "FIND_STACK_TARCE_FAIL", "查找栈针信息失败");

        try {
            return clazz.getMethod(stackTraceElement.getMethodName(), parameterTypes);
        } catch (NoSuchMethodException e) {
            LOGGER.info("{}|{}|{}", "GET_METHOD_ERROR", "getMethod", e);
        }

        return null;
    }

    /**
     * 设置markdown的标题
     *
     * @param method 元方法
     * @return 标题
     */
    private static StringBuilder setResTitle(Method method) {
        Assert.notNull(method, "NO_SUCH_METHOD", "系统繁忙,请稍后再试");

        GenerateMethodName methodName = method.getAnnotation(GenerateMethodName.class);
        Assert.isTrue(Objects.nonNull(methodName), "NO_ANNOTATION_MARK", "方法上没有对应注解");

        return new StringBuilder(String.format("**%s** \n\n", methodName.title()));
    }

    /**
     * 获取全部字段信息
     *
     * @param res 结果
     * @param t   t
     * @param <T> 范形
     */
    private static <T> void getFields(StringBuilder res, T t) {
        Field[] declaredFields = t.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            GenerateFieldName fieldName = field.getAnnotation(GenerateFieldName.class);

            if (Objects.isNull(fieldName)) {
                continue;
            }

            try {
                field.setAccessible(true);
                Object object = field.get(t);

                //判断子类中的字段是否需要展示
                if (fieldName.isRecursive() && Objects.nonNull(object)) {
                    fieldName.isRecursive();
                    getFields(res, object);
                }

                //子类本身的信息不展示
                if ((Objects.nonNull(object) || fieldName.isNullShow()) && !fieldName.isRecursive()) {
                    res.append(String.format(fieldName.name() + ": %s \n\n", Optional.ofNullable(object).orElse("")));
                }

                field.setAccessible(false);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }
}
