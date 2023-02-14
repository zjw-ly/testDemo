package com.demo.experiment.domain.types;

import com.alibaba.fastjson.JSONObject;
import com.demo.experiment.domain.entity.Bucket;
import com.demo.experiment.domain.entity.Experiment;
import com.demo.experiment.utils.LogUtils;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * 实验日志
 *
 * @author zaochun.zjw
 * @date 2023/2/13
 */
@Data
@Builder
public class ExperimentLog {

    /** 业务标识 */
    private String bizCode;

    /** 业务描述 */
    private String bizDesc;

    /** 实验code */
    private String experimentCode;

    /** 实验名称 */
    private String experimentName;

    /** 分桶code */
    private String bucketCode;

    /** 分桶名称 */
    private String bucketName;

    /** 是否空桶 */
    private boolean empty;

    /** 实验层级 */
    private int level;

    /** 用户ID */
    private long userId;

    /** traceId */
    private String traceId;

    /** 扩展属性 */
    private Map<String, Object> extendAttr;

    /**
     * 打印日志
     *
     * @param objectId   项目id
     * @param userId     用户id
     * @param attribute  扩展属性
     * @param experiment 实验对象
     * @param bucket     分桶
     * @return 日志对象
     */
    public static ExperimentLog of(String objectId, long userId, Map<String, Object> attribute, Experiment experiment, Bucket bucket) {
        return ExperimentLog
            .builder()
            .bizCode(objectId)
            .bizDesc(objectId)
            .experimentCode(experiment.getExperimentCode())
            .experimentName(experiment.getExperimentName())
            .level(experiment.getLevel())
            .bucketCode(bucket.getBucketCode())
            .bucketName(bucket.getBucketName())
            .empty(bucket.isEmpty())
            .extendAttr(attribute)
            .userId(userId)
            .build();
    }

    /**
     * 打印日志
     */
    public void print() {
        LogUtils.info("{}|{}|{}|{}|{}|{}|{}|{}|{}|{}", bizCode, bizDesc, experimentCode, experimentName, bucketCode, bucketName, empty, level, userId, JSONObject.toJSONString(extendAttr));
    }
}
