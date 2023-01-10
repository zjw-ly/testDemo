package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * http配置类
 *
 * @author zaochun.zjw
 * @date 2023/1/9
 */
@ConfigurationProperties(prefix = "http")
public class HttpProperties {

    private String url = "http://www.baidu.com";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
