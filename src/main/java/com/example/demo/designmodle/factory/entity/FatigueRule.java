package com.example.demo.designmodle.factory.entity;

import com.example.demo.designmodle.factory.type.RuleCode;

/**
 * 疲劳度规则
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
public class FatigueRule implements Rule {

    @Override
    public String getRuleName() {
        return RuleCode.FATIGUE_RULE.getDesc();
    }

    @Override
    public RuleCode getCode() {
        return RuleCode.FATIGUE_RULE;
    }
}
