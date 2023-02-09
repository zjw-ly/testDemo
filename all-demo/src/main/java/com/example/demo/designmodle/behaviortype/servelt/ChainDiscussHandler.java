package com.example.demo.designmodle.behaviortype.servelt;

import com.example.demo.designmodle.behaviortype.servelt.type.RequestContext;
import com.example.demo.designmodle.behaviortype.servelt.demo.AuthorityHandler;
import com.example.demo.designmodle.behaviortype.servelt.demo.FuseHandler;

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
    private static final List<AbstractChainHandler> invokeHandlerChainList = new LinkedList<AbstractChainHandler>() {
        {
            add(AuthorityHandler.getInstance(15));
            add(FuseHandler.getInstance(14));
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
            invokeHandlerChainList.sort(AbstractChainHandler::compareTo);
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

    public static void main(String[] args) {
        ChainDiscussHandler handler = new ChainDiscussHandler();
        RequestContext context = new RequestContext();
        context.setUserId("111");
        handler.invokeHandler(context);
    }
}
