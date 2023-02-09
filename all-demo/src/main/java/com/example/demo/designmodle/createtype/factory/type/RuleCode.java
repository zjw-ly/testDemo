package com.example.demo.designmodle.createtype.factory.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 规则编码
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
@AllArgsConstructor
@Getter
public enum RuleCode {

    CROWD_RULE("人群规则"),

    FATIGUE_RULE("疲劳度规则"),
    ;

    private final String desc;
}
