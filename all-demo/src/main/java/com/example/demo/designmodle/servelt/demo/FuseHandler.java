package com.example.demo.designmodle.servelt.demo;

import com.example.demo.designmodle.servelt.AbstractChainHandler;
import com.example.demo.designmodle.servelt.BaseChainHandler;
import com.example.demo.designmodle.servelt.type.RequestContext;
import com.example.demo.exception.Assert;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 熔断
 *
 * @author zaochun.zjw
 * @date 2023/2/8
 */
@Data
@NoArgsConstructor
public class FuseHandler extends AbstractChainHandler implements BaseChainHandler {

    private Integer order;

    public static FuseHandler getInstance(Integer order){
        return new FuseHandler(order);
    }

    public FuseHandler (Integer order){
        this.order = order;
    }

    @Override
    public void executeHandler(RequestContext gateWayContext) {
        System.out.println("熔断校验");
        Assert.isTrue(gateWayContext.isFuse(), "GATEWAY_FUSE", "风控服务熔断");
    }
}
