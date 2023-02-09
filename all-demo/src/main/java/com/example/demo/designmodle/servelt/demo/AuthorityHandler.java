package com.example.demo.designmodle.servelt.demo;

import com.example.demo.designmodle.servelt.BaseChainHandler;
import com.example.demo.designmodle.servelt.type.RequestContext;
import com.example.demo.exception.Assert;

/**
 * 权限校验责任链模式
 *
 * @author zaochun.zjw
 * @date 2023/2/8
 */
public class AuthorityHandler implements BaseChainHandler {

    @Override
    public void executeHandler(RequestContext gateWayContext) {
        Assert.isFalse(gateWayContext.isInWriteList(),"","");
    }
}
