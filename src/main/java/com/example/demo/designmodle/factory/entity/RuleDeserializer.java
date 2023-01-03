package com.example.demo.designmodle.factory.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.example.demo.designmodle.factory.type.RuleCode;
import com.example.demo.exception.Assert;

import java.lang.reflect.Type;

/**
 * 规则反序列化方法
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
public class RuleDeserializer  implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object o) {
        JSONObject jsonObject = parser.parseObject();
        Assert.notNull(jsonObject, "rule is null of " + o);

        String code = jsonObject.getString("ruleCode");
        Assert.notNull(code, "rule code not found, please see DingRuleCode");

        Rule rule = null;

        RuleCode ruleCode = RuleCode.valueOf(code);
        switch (ruleCode) {
            case CROWD_RULE:
                rule = jsonObject.toJavaObject(CrowdRule.class);
                break;
            case FATIGUE_RULE:
                rule = jsonObject.toJavaObject(FatigueRule.class);
                break;
            default:
                throw new IllegalArgumentException("RuleCode of " + code + " was not implemented for " + jsonObject);
        }

        Assert.notNull(rule, "deserialize rule is null of code:" + code);

        return (T)rule;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
