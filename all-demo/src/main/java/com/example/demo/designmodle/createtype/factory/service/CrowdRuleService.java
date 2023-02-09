package com.example.demo.designmodle.createtype.factory.service;

import com.example.demo.designmodle.createtype.factory.entity.CrowdRule;
import com.example.demo.designmodle.createtype.factory.type.RuleCode;
import com.example.demo.designmodle.createtype.factory.type.RuleContext;
import org.springframework.stereotype.Component;

/**
 * 人群规则服务
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
@Component
public class CrowdRuleService extends CommonRuleService<CrowdRule>{

    @Override
    RuleCode getSupportRule() {
        return RuleCode.CROWD_RULE;
    }

    @Override
    String getMarkDownRes(CrowdRule rule, RuleContext context) {
        return "人群规则自定义逻辑";
    }
}
