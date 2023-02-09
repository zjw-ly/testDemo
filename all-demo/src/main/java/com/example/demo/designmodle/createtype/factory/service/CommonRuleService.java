package com.example.demo.designmodle.createtype.factory.service;

import com.example.demo.designmodle.createtype.factory.entity.Rule;
import com.example.demo.designmodle.createtype.factory.type.RuleCode;
import com.example.demo.designmodle.createtype.factory.type.RuleContext;
import org.springframework.beans.factory.InitializingBean;

/**
 * 公共规则服务
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
public abstract class CommonRuleService<T extends Rule> implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        RuleFactory.register(this);
    }

    /**
     * 获取支持的规则
     *
     * @return 支持的规则
     */
    abstract RuleCode getSupportRule();

    /**
     * 获取markDown返回值
     *
     * @param rule    规则
     * @param context 上下文
     * @return markDown返回值
     */
    abstract String getMarkDownRes(T rule, final RuleContext context);
}
