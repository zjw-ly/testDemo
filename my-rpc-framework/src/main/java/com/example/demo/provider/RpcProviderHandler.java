package com.example.demo.provider;

import com.example.demo.commons.ProviderUtils;
import com.example.demo.protocol.RpcRequest;
import com.example.demo.protocol.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.reflect.FastClass;

import java.util.Map;

/**
 * rpc提供者处理器
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
@Slf4j
public class RpcProviderHandler extends SimpleChannelInboundHandler<RpcRequest> {

    private final Map<String,Object> handlerMap;

    public RpcProviderHandler(Map<String,Object> handlerMap){
        this.handlerMap = handlerMap;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequest request) throws Exception {
        RpcProvider.submit(()->{
            RpcResponse response = new RpcResponse();
            response.setRequestId(response.getRequestId());
            try {
                Object result = handle(request);
                response.setResult(result);
            }catch (Throwable e){
                response.setError(e.toString());
            }

            ctx.writeAndFlush(response).addListener(channelFuture -> log.debug("Send response for request " + request.getRequestId()));
        });
    }

    private Object handle(RpcRequest request) throws Throwable {
        String providerKey = ProviderUtils.makeKey(request.getClassName(), request.getServiceVersion());
        Object providerBean = handlerMap.get(providerKey);

        if (null == providerBean) {
            throw new RuntimeException(String.format("provider not exist: %s:%s", request.getClassName(),
                                                     request.getMethodName()));
        }

        Class<?> providerClass = providerBean.getClass();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] parameters = request.getParameters();

        log.debug(providerClass.getName());
        log.debug(methodName);
        for (int i = 0; i < parameterTypes.length; ++i) {
            log.debug(parameterTypes[i].getName());
        }
        for (int i = 0; i < parameters.length; ++i) {
            log.debug(parameters[i].toString());
        }

        //快速建立对应的类
        FastClass providerFastClass = FastClass.create(providerClass);
        int methodIndex = providerFastClass.getIndex(methodName, parameterTypes);
        return providerFastClass.invoke(methodIndex, providerBean, parameters);
    }
}
