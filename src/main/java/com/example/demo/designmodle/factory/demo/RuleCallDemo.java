package com.example.demo.designmodle.factory.demo;

import com.example.demo.designmodle.factory.entity.Rule;
import com.example.demo.designmodle.factory.service.RuleFactory;
import com.example.demo.designmodle.factory.type.RuleCode;
import com.example.demo.designmodle.factory.type.RuleContext;
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
        return RuleFactory.getMarkDowRes(rule,new RuleContext());
    }
}
