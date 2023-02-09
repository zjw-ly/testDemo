package com.example.demo.designmodle.createtype.factory.service;

import com.example.demo.designmodle.createtype.factory.entity.Rule;
import com.example.demo.designmodle.createtype.factory.type.RuleCode;
import com.example.demo.designmodle.createtype.factory.type.RuleContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 规则工厂
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
public class RuleFactory {

    private static final Map<RuleCode, CommonRuleService> RULE_MAP = new HashMap<>();


    /**
     * 注册规则服务
     *
     * @param ruleService 规则服务
     */
    public static void register(CommonRuleService ruleService) {
        RULE_MAP.put(ruleService.getSupportRule(), ruleService);
    }

    /**
     * 获取markDown返回信息
     *
     * @param rule    分发规则
     * @param context 上下文
     * @return markdown信息
     */
    public static String getMarkDowRes(Rule rule, final RuleContext context) {
        return RULE_MAP.get(rule.getCode()).getMarkDownRes(rule, context);
    }
}
