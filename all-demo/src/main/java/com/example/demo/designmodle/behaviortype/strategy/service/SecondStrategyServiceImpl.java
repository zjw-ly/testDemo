package com.example.demo.designmodle.behaviortype.strategy.service;

import com.example.demo.designmodle.behaviortype.strategy.type.StrategyEnum;
import com.example.demo.designmodle.behaviortype.strategy.type.StrategyEnumMark;
import org.springframework.stereotype.Repository;

/**
 * @author zaochun.zjw
 * @date 2023/2/9
 */
@Repository
@StrategyEnumMark(strategyEnum = StrategyEnum.SECOND_STRATEGY)
public class SecondStrategyServiceImpl implements StrategyHandler {

    @Override
    public void executeHandler() {

    }
}
