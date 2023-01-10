package com.example.demo.designmodle.servlet.service;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 商品权限规则校验 -  继承自AbstarctOrderFilter，遵守单一职责原则，实现多种Filter
 *
 * @author zaochun.zjw
 * @date 2023/1/6
 */
public class ItemPermissionFilter extends AbstractOrderFilter{

    private ItemPermissionFilter(Integer order){
        super.order = order;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        if(accept(new Object())){
            //执行过滤器逻辑校验
        }
        chain.doFilter(request,servletResponse);
    }

    @Override
    public boolean accept(Object object){
        //定制化逻辑 判断对象是否满足条件 ->满足再做校验
        return true;
    }

    @Override
    public void destroy() {

    }
}
