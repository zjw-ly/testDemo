package com.example.demo.registry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

/**
 * 服务元数据
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceMetadata {

    /** 服务名 */
    private String serviceName;

    /** 服务版本号 */
    private String serviceVersion;

    /** 服务方提供的地址 */
    private String address;

    /** 服务方暴露的端口号 */
    private int port;
}
