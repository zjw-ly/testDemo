package com.example.demo.designmodle.servlet.service;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

/**
 * 过滤器
 *
 * @author zaochun.zjw
 * @date 2023/1/6
 */
public interface FilterChain {

    /**
     * 执行过滤
     *
     * @param request  请求
     * @param response 返回
     * @throws IOException     io异常
     * @throws ServerException
     */
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException;
}
