package com.demo.experiment.utils;

import ch.qos.logback.classic.AsyncAppender;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.encoder.Encoder;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.RollingPolicy;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.util.FileSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 日志打印文件 ——（创建日志 和xml文件异曲同工）
 *
 * @author zaochun.zjw
 * @date 2023/2/10
 */
public class LogUtils {

    private static final String LOG_NAME = "experiment";

    private static final Logger DEFAULT_LOGGER = LoggerFactory.getLogger(LogUtils.class);

    private static final Map<String, Logger> LOGGERS = new ConcurrentHashMap<>();

    private static final LoggerContext LC = new LoggerContext() {
        {
            setName("experiment");
        }
    };

    /**
     * 打印info日志
     *
     * @param format 格式
     * @param args   参数
     */
    public static void info(String format, Object... args) {
        Optional<Logger> optional = getLogger(LOG_NAME);
        if (optional.isPresent()) {
            optional.get().info(format, args);
            return;
        }
    }

    /**
     * 获取日志
     *
     * @param name 日志名
     * @return 获取日志
     */
    private static Optional<Logger> getLogger(String name) {
        if (Objects.isNull(name)) {
            return Optional.empty();
        }

        Logger logger = LOGGERS.get(name);
        if (Objects.nonNull(logger)) {
            return Optional.of(logger);
        }

        synchronized (LogUtils.class) {
            logger = LOGGERS.get(name);
            if (Objects.nonNull(logger)) {
                return Optional.of(logger);
            }

            try {
                logger = createLogger(name);

                LOGGERS.put(name, logger);

                return Optional.ofNullable(logger);
            } catch (Throwable e) {
                DEFAULT_LOGGER.error("create logger:{}", name, e);
            }
        }

        return Optional.empty();
    }

    /**
     * 创建日志
     *
     * @param name 日志名
     * @return 日志实现
     */
    private static ch.qos.logback.classic.Logger createLogger(String name) {
        String logFileName = getSystemLogHome() + "/" + name + ".log";

        return createLogger(name, logFileName);
    }

    /**
     * 创建日志
     *
     * @param name     日志名
     * @param fileName 日志文件名
     * @return 日志实现
     */
    private static ch.qos.logback.classic.Logger createLogger(String name, String fileName) {
        AsyncAppender asyncAppender = createAsyncAppender(fileName);

        ch.qos.logback.classic.Logger logger = LC.getLogger(name);
        logger.setAdditive(false);
        logger.addAppender(asyncAppender);

        return logger;
    }

    /**
     * 创建异步日志
     *
     * @param fileName 日志文件名
     * @return 异步日志
     */
    private static AsyncAppender createAsyncAppender(String fileName) {
        AsyncAppender asyncAppender = new AsyncAppender();
        asyncAppender.setContext(LC);
        asyncAppender.addAppender(createRollingFileAppender(fileName));
        asyncAppender.setQueueSize(1024);
        asyncAppender.setDiscardingThreshold(0);
        asyncAppender.setName("ExperimentAsyncAppender");
        asyncAppender.start();

        return asyncAppender;
    }

    /**
     * 创建滚动文件日志
     *
     * @param fileName 日志文件名
     * @return 滚动文件日志
     */
    private static RollingFileAppender createRollingFileAppender(String fileName) {
        RollingFileAppender rollingFileAppender = new RollingFileAppender();
        rollingFileAppender.setContext(LC);
        rollingFileAppender.setFile(fileName);
        rollingFileAppender.setEncoder(createPatternLayoutEncode());
        rollingFileAppender.setRollingPolicy(createRollingPolicy(rollingFileAppender, fileName));
        rollingFileAppender.setName("ExperimentRollingFileAppender");
        rollingFileAppender.start();

        return rollingFileAppender;
    }

    /**
     * 创建日志打印格式
     *
     * @return 日志打印格式
     */
    private static Encoder createPatternLayoutEncode() {
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss.SSS}|%msg%n");
        encoder.setContext(LC);
        encoder.start();

        return encoder;
    }

    /**
     * 创建滚动方式
     *
     * @param appender
     * @param fileName
     * @return
     */
    private static RollingPolicy createRollingPolicy(RollingFileAppender appender, String fileName) {
        SizeAndTimeBasedRollingPolicy policy = new SizeAndTimeBasedRollingPolicy();
        policy.setContext(LC);
        policy.setParent(appender);
        policy.setFileNamePattern(fileName + ".%d{yyyy-MM-dd}.%i");
        policy.setMaxFileSize(FileSize.valueOf("200MB"));
        policy.setMaxHistory(2);
        policy.setTotalSizeCap(FileSize.valueOf("2GB"));
        policy.start();

        return policy;
    }

    /**
     * 获取用户目录
     *
     * @return 用户目录
     */
    private static String getUserHome() {
        String userHome = System.getProperty("user.home");

        return userHome == null || userHome.trim().isEmpty() ? "/home/admin" : userHome.trim();
    }

    /**
     * 获取项目名称
     *
     * @return 项目名称
     */
    private static String getProjectName() {
        return System.getProperty("project.name");
    }

    /**
     * @return
     */
    private static String getProjectLogHome() {
        String projectName = getProjectName();
        if (projectName == null || projectName.trim().isEmpty()) {
            return getSystemLogHome();
        }

        return getUserHome() + "/" + projectName + "/logs";
    }

    private static String getSystemLogHome() {
        return getUserHome() + "/logs/experiment-sdk";
    }
}
