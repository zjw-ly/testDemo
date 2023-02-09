package com.example.demo.designmodle.behaviortype.strategy.type;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import java.lang.annotation.*;

/**
 * 标注
 *
 * @author zaochun.zjw
 * @date 2023/2/9
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@CommandLine.Command
public @interface StrategyEnumMark {

    /**
     * 获取策略
     *
     * @return
     */
    StrategyEnum strategyEnum();
}
