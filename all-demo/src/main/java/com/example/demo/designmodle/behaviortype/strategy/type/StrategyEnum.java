package com.example.demo.designmodle.behaviortype.strategy.type;

import lombok.Getter;

/**
 * 策略枚举
 *
 * @author zaochun.zjw
 * @date 2023/2/9
 */
@Getter
public enum StrategyEnum {

    FIRST_STRATEGY("FIRST_STRATEGY", "第一个策略"),

    SECOND_STRATEGY("SECOND_STRATEGY", "第二个策略");

    private final String code;

    private final String desc;

    StrategyEnum(String code, String strategy) {
        this.code = code;
        this.desc = strategy;
    }
}
