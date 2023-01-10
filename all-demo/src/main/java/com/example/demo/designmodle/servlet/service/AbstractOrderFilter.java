package com.example.demo.designmodle.servlet.service;

import lombok.Data;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 抽象类 - 抽象过滤器 对于责任链来说 过滤器是一种相当正常的dmo
 *
 * @author zaochun.zjw
 * @date 2023/1/6
 */
@Data
public abstract class AbstractOrderFilter implements Filter, Comparable<AbstractOrderFilter> {

    protected Integer order;

    /**
     * 自定义是否处理逻辑
     *
     * @param object
     * @return
     */
    public boolean accept(Object object){
        return true;
    }


    @Override
    public int compareTo(AbstractOrderFilter o) {
        return getOrder().compareTo(o.getOrder());
    }
}
