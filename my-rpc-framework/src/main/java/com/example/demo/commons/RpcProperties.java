package com.example.demo.commons;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 用于和 自定义配置文件相连,这里面主要包括了，服务地址、服务注册地址、服务注册中心类型
 *
 * @author 早春
 * @date 2020/6/5
 **/

@Data
@ConfigurationProperties(prefix = "rpc")
public class RpcProperties {

    private String serviceAddress;

    private String serviceRegistryAddress;

    private String serviceRegistryType;
}
