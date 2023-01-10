package com.example.demo.designmodle.servlet.service;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 自定义过滤链
 *
 * @author zaochun.zjw
 * @date 2023/1/6
 */
public class CouponFilterChain implements FilterChain{

    /** 责任链表中所有的处理组件 - 非变量 */
    private final List<? extends AbstractOrderFilter> filters;

    private static ThreadLocal<Integer> posLocal = ThreadLocal.withInitial(() ->0);

    public CouponFilterChain(List<? extends AbstractOrderFilter> filters) {
        this.filters = filters;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {

    }
}
