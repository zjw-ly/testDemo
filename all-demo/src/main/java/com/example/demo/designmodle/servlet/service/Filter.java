package com.example.demo.designmodle.servlet.service;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 *
 * @author zaochun.zjw
 * @date 2023/1/6
 */
public interface Filter {

    /**
     * 初始化方法
     *
     * @param filterConfig 过滤配置
     * @throws ServletException servlet异常
     */
    void init(FilterConfig filterConfig)throws ServletException;

    /**
     * 处理逻辑
     *
     * @param request
     * @param servletResponse
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain chain) throws IOException,ServletException;

    /**
     * 生命周期销毁
     */
    void destroy();
}
