package com.example.demo.designmodle.factory.entity;

import com.alibaba.fastjson.annotation.JSONType;
import com.example.demo.designmodle.factory.type.RuleCode;

/**
 * 抽象规则
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
@JSONType(deserializer = RuleDeserializer.class)
public interface Rule {

    //@JSONType(deserializer = xxx） 代表自定义反序列化方法
    /**
     * 获取规则名称
     *
     * @return 规则名称
     */
    String getRuleName();

    /**
     * 获取规则唯一编码
     *
     * @return 规则唯一编码
     */
    RuleCode getCode();
}
