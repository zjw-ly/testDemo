package com.example.demo.designmodle.behaviortype.strategy.service;

import com.example.demo.designmodle.behaviortype.strategy.type.StrategyEnum;
import com.example.demo.designmodle.behaviortype.strategy.type.StrategyEnumMark;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂
 *
 * @author zaochun.zjw
 * @date 2023/2/9
 */
@Component
public class StrategyFactory implements ApplicationListener<ContextRefreshedEvent> {

    private static final Map<String, StrategyHandler> STRATEGY_HANDLER_MAP = new HashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(StrategyEnumMark.class);
        if (beans == null || beans.isEmpty()) {
            return;
        }

        for (Object key : beans.keySet()) {
            StrategyEnumMark strategyEnumMark = AnnotationUtils.findAnnotation(AopUtils.getTargetClass(beans.get(key)), StrategyEnumMark.class);
            StrategyEnum strategyEnum = strategyEnumMark.strategyEnum();
            if (beans.get(key) instanceof StrategyHandler) {
                STRATEGY_HANDLER_MAP.put(strategyEnum.getCode(), (StrategyHandler) beans.get(key));
            }
        }
    }

    /**
     * 获取对应策虑
     *
     * @param code
     * @return
     */
    public static StrategyHandler getStrategy(String code) {
        return STRATEGY_HANDLER_MAP.get(code);
    }
}
