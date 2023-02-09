package com.example.demo.designmodle.createtype.factory.demo;

import com.example.demo.designmodle.createtype.factory.entity.Rule;
import com.example.demo.designmodle.createtype.factory.service.RuleFactory;
import com.example.demo.designmodle.createtype.factory.type.RuleContext;
import org.springframework.stereotype.Component;

/**
 * 规则调用demo
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
@Component
public class RuleCallDemo {

    private String getRes(Rule rule){
        return RuleFactory.getMarkDowRes(rule, new RuleContext());
    }
}
