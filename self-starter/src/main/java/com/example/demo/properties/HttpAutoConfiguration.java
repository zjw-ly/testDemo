package com.example.demo.properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 创建http的autoconfiguration
 *
 * @author zaochun.zjw
 * @date 2023/1/9
 */
@Configuration
@EnableConfigurationProperties(HttpProperties.class)
public class HttpAutoConfiguration {

    @Resource
    private HttpProperties properties;

    @Bean
    // conditionOnMissingBean 的注解是指在bean不存在的情况下，此方法才会执行。这个相当于开关的角色
    @ConditionalOnMissingBean
    public HttpClient init(){
        HttpClient client = new HttpClient();

        String url = properties.getUrl();
        client.setUrl(url);
        return client;
    }
}
