package com.example.demo.designmodle.behaviortype.servelt.demo;

import com.example.demo.designmodle.behaviortype.servelt.BaseChainHandler;
import com.example.demo.designmodle.behaviortype.servelt.type.RequestContext;
import com.example.demo.designmodle.behaviortype.servelt.AbstractChainHandler;
import com.example.demo.exception.Assert;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限校验责任链模式
 *
 * @author zaochun.zjw
 * @date 2023/2/8
 */
@Data
@NoArgsConstructor
public class AuthorityHandler extends AbstractChainHandler implements BaseChainHandler {

    private Integer order;

    public static AuthorityHandler getInstance(Integer order){
        return new AuthorityHandler(order);
    }

    public AuthorityHandler (Integer order){
        this.order = order;
    }

    @Override
    public void executeHandler(RequestContext gateWayContext) {
        System.out.println("权限校验");
        Assert.isTrue(gateWayContext.isInWriteList(),"","");
    }
}
