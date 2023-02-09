package com.example.demo.designmodle.createtype.factory.service;

import com.example.demo.designmodle.createtype.factory.entity.FatigueRule;
import com.example.demo.designmodle.createtype.factory.type.RuleCode;
import com.example.demo.designmodle.createtype.factory.type.RuleContext;
import org.springframework.stereotype.Component;

/**
 * 疲劳度规则服务
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
@Component
public class FatigueRuleService extends CommonRuleService<FatigueRule>{

    @Override
    RuleCode getSupportRule() {
        return RuleCode.FATIGUE_RULE;
    }

    @Override
    String getMarkDownRes(FatigueRule rule, RuleContext context) {
        return "疲劳度规则自定义逻辑";
    }
}
