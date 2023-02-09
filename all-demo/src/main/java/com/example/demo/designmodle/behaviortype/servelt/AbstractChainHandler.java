package com.example.demo.designmodle.behaviortype.servelt;

import com.example.demo.designmodle.behaviortype.servelt.type.RequestContext;
import lombok.Data;

/**
 * 抽象类处理器
 *
 * @author zaochun.zjw
 * @date 2023/2/9
 */
@Data
public class AbstractChainHandler implements BaseChainHandler,Comparable<AbstractChainHandler> {

    private Integer order;

    @Override
    public int compareTo(AbstractChainHandler o) {
        return getOrder().compareTo(o.getOrder());
    }

    @Override
    public void executeHandler(RequestContext gateWayContext) {

    }
}
