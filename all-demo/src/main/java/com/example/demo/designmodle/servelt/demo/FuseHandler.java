package com.example.demo.designmodle.servelt.demo;

import com.example.demo.designmodle.servelt.BaseChainHandler;
import com.example.demo.designmodle.servelt.type.RequestContext;
import com.example.demo.exception.Assert;

/**
 * 熔断
 *
 * @author zaochun.zjw
 * @date 2023/2/8
 */
public class FuseHandler implements BaseChainHandler {

    @Override
    public void executeHandler(RequestContext gateWayContext) {
        Assert.isFalse(gateWayContext.isFuse(), "GATEWAY_FUSE", "风控服务熔断");
    }
}
