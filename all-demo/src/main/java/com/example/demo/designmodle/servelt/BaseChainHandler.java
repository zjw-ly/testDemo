package com.example.demo.designmodle.servelt;

import com.example.demo.designmodle.servelt.type.RequestContext;

/**
 * 责任链接口
 *
 * @author zaochun.zjw
 * @date 2023/2/8
 */
public interface BaseChainHandler {

    /**
     * 处理器
     */
    void executeHandler(RequestContext gateWayContext);
}
