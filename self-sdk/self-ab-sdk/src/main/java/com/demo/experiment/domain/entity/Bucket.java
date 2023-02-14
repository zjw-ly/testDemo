package com.demo.experiment.domain.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 筒
 *
 * @author zaochun.zjw
 * @date 2023/2/10
 */
@Data
public class Bucket {

    /** 分桶code */
    private String bucketCode;

    /** 分桶名称 */
    private String bucketName;

    /** 分桶比例 */
    private int rate;

    /** 是否空桶 */
    private boolean empty;

    /** 分桶白名单 */
    private String whiteUsers;

    /**
     * 是否在白名单中
     *
     * @param userId 用户ID
     * @return 结果
     */
    public boolean inWhiteUsers(long userId) {
        if (StringUtils.isBlank(whiteUsers)) {
            return false;
        }

        return Arrays.stream(whiteUsers.split(","))
            .anyMatch(l -> l.equals(userId + ""));
    }
}
