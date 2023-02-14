package com.demo.experiment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实验结果
 *
 * @author sunmingjie
 * @date 2023/1/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperimentResult {

    /** 分桶code */
    private String bucketCode;

    /** 分桶名称 */
    private String bucketName;

    /** 是否空桶 */
    private boolean empty;

    public static ExperimentResult of(String bucketCode, String bucketName, boolean empty) {
        return new ExperimentResult(bucketCode, bucketName, empty);
    }
}
