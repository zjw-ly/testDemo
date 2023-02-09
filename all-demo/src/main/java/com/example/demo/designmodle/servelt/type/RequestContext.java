package com.example.demo.designmodle.servelt.type;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 请求上下文
 *
 * @author zaochun.zjw
 * @date 2023/2/8
 */
@Data
public class RequestContext {

    /** 第一个参数 */
    private String firstParam;

    /** 请求id */
    private Long requestId;

    /** 用户id */
    private String userId;

    /** 白名单 */
    private List<Long> writeList;

    /** 是否熔断 */
    private boolean isFuse = true;

    /**
     * 是否在白名单中
     *
     * @return
     */
    public boolean isInWriteList() {
        if (CollectionUtils.isEmpty(writeList)) {
            return true;
        }

        return writeList.contains(userId);
    }
}
