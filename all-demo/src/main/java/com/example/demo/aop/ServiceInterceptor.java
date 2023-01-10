package com.example.demo.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * 统一 切面 aspect表明是一个切面
 *
 * @author zaochun.zjw
 * @date 2022/10/26
 */
@Aspect
@Component
public class ServiceInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInterceptor.class);


    @Pointcut(value = "@annotation(serviceAspect)")
    public void serviceAspectPoint(ServiceAspect serviceAspect) {
    }

    public Object coreServiceMonitor(ProceedingJoinPoint pjp, ServiceAspect serviceAspect) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 获取方法签名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getDeclaringType().getSimpleName() + "#"
            + signature.getMethod().getName();

        // 通过自定义注解拿到返回类型 ！！！
        Class responseType = serviceAspect.responseType();
        Object[] args = pjp.getArgs();
        Object result = null;

        try {
            LOGGER.info("{}|{}|{}", log, methodName + "请求参数 request={}", JSON.toJSON(args));
            result = pjp.proceed();
            LOGGER.info("{}|{}|{}", log, methodName + "响应结果 result={}", JSON.toJSON(result));
            return result;
        } catch (Throwable e) {
            //统一处理其他异常
            LOGGER.error("{}|{}|{}", e, "服务系统异常" + "ServiceInterceptor");
        } finally {
            //finally 打日志
            //方法自己定义，记录内容自己根据需要确定
        }

        return pjp.proceed();
    }
}
