package com.example.demo.designmodle.servelt;

import com.example.demo.designmodle.servelt.demo.AuthorityHandler;
import com.example.demo.designmodle.servelt.demo.FuseHandler;
import com.example.demo.designmodle.servelt.type.RequestContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 责任链处理
 *
 * @author zaochun.zjw
 * @date 2023/2/8
 */
public class ChainDiscussHandler {

    /**
     * invoke handler chain list
     */
    private static final List<BaseChainHandler> invokeHandlerChainList = new LinkedList<BaseChainHandler>() {
        {
            add(new AuthorityHandler());
            add(new FuseHandler());
        }
    };

    private static final List<BaseChainHandler> responseHandlerChainList = new LinkedList<BaseChainHandler>() {
        {
            //后置测试
            add(new BaseChainHandler() {
                @Override
                public void executeHandler(RequestContext gateWayContext) {

                }
            });
        }
    };

    public void invokeHandler(RequestContext context) {
        executeHandler(() -> {
            invokeHandlerChainList.stream().forEach(handler -> handler.executeHandler(context));
            return true;
        });
    }

    public void responseHandler(RequestContext context) {
        executeHandler(() -> {
            responseHandlerChainList.stream().forEach(handler -> handler.executeHandler(context));
            return false;
        });
    }

    public void executeHandler(Supplier<Boolean> supplier) {
        supplier.get();
    }
}
