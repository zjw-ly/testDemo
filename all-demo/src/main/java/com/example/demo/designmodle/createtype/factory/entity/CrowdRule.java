package com.example.demo.designmodle.createtype.factory.entity;

import com.example.demo.designmodle.createtype.factory.type.RuleCode;

/**
 * 人群规则
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
public class CrowdRule implements Rule{

    /** 人群号 */
    private Integer code;

    @Override
    public String getRuleName() {
        return RuleCode.CROWD_RULE.getDesc();
    }

    @Override
    public RuleCode getCode() {
        return RuleCode.CROWD_RULE;
    }
}
