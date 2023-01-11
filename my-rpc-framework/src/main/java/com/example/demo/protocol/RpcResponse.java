package com.example.demo.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fuxi@cainiao.com
 * @date 2020/6/4
 **/

@Data
public class RpcResponse implements Serializable {

    private String requestId;

    private String error;

    private Object result;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RpcResponse{");
        sb.append("requestId='").append(requestId).append('\'');
        sb.append(", error='").append(error).append('\'');
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }
}
