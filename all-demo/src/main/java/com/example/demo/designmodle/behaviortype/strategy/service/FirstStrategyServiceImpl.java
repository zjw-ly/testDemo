package com.example.demo.designmodle.behaviortype.strategy.service;

import com.example.demo.designmodle.behaviortype.strategy.type.StrategyEnum;
import com.example.demo.designmodle.behaviortype.strategy.type.StrategyEnumMark;
import org.springframework.stereotype.Repository;

/**
 * 第一个策略执行处理器
 *
 * @author zaochun.zjw
 * @date 2023/2/9
 */
@Repository
@StrategyEnumMark(strategyEnum = StrategyEnum.FIRST_STRATEGY)
public class FirstStrategyServiceImpl implements StrategyHandler{

    @Override
    public void executeHandler() {

    }
}
