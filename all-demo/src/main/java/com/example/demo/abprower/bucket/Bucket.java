package com.example.demo.abprower.bucket;

import lombok.Data;

/**
 * 分流桶
 *
 * @author zaochun.zjw
 * @date 2023/5/25
 */
@Data
public class Bucket {

    /** 比例 */
    private long rate;

    /** 桶名称 */
    private String bucketName;

    /** 是否是空桶 */
    private boolean empty = false;
}
