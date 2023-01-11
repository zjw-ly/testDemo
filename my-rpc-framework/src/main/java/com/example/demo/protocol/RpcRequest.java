package com.example.demo.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fuxi@cainiao.com
 * @date 2020/6/4
 **/

@Data
public class RpcRequest implements Serializable {
    private String requestId;
    private String className;
    private String methodName;
    private String serviceVersion;
    private Class<?>[] parameterTypes;
    private Object[] parameters;

}
