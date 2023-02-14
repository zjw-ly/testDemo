package com.demo.experiment.service;

import com.demo.experiment.diamond.ExperimentSdkConfig;
import com.demo.experiment.domain.entity.Bucket;
import com.demo.experiment.domain.entity.Experiment;
import com.demo.experiment.domain.types.ExperimentLog;
import com.demo.experiment.dto.ExperimentResult;
import com.demo.experiment.exception.Assert;
import com.demo.experiment.exception.BizException;
import com.demo.experiment.utils.MurMurHashUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 实验服务
 *
 * @author zaochun.zjw
 * @date 2023/2/13
 */
@Slf4j
public class ExperimentService {

    /**
     * 进行AB实验
     *
     * @param objectId       业务id
     * @param userId         用户id
     * @param experimentCode 实验code
     * @param attribute      扩展属性
     * @return
     */
    public static ExperimentResult ab(String objectId, long userId, String experimentCode, Map<String, Object> attribute) {
        try {
            //diamond ab全局降级开关
            boolean diamondGlobalSwitch = false;
            if (diamondGlobalSwitch) {
                // 降级后 默认所有请求进入非空桶
                return ExperimentResult.of("GLOBAL_DOWNGRADE", "全局降级", false);
            }

            //查找实验
            Experiment experiment = getExperiment(experimentCode);

            // 查找分桶
            Bucket bucket = experiment.find(userId);

            // 打印实验日志
            ExperimentLog.of(objectId, userId, attribute, experiment, bucket).print();

            return ExperimentResult.of(bucket.getBucketCode(), bucket.getBucketName(), bucket.isEmpty());
        } catch (Throwable e) {
            // 打印sdk统一日常日志，做日常监控使用
            log.error("experiment|ab|error|{}|{}|{}|{}", objectId, userId, experimentCode, e.getMessage());
            log.error("experiment|ab|error|stack", e);

            return ExperimentResult.of("ERROR_BUCKET", "异常桶", false);
        }
    }

    /**
     * 根据指定的salt和比例 判断是否命中
     *
     * @param objectId      业务标识
     * @param userId        用户ID
     * @param salt          分流因子
     * @param thresholdRate 比例
     * @param attribute     扩展属性
     * @return 是否命中
     */
    public static boolean ab(String objectId, long userId, String salt, int thresholdRate, Map<String, Object> attribute) {
        try {
            // 是否在比例中
            int rate = MurMurHashUtil.routing(userId, salt);

            boolean isHit = rate < (thresholdRate * 10000);

            // 打印实验日志
            ExperimentLog experimentLog = ExperimentLog
                .builder()
                .bizCode(objectId)
                .bizDesc(objectId)
                .userId(userId)
                .extendAttr(attribute)
                .bucketName(isHit ? "A" : "B")
                .bucketCode(isHit ? "A" : "B")
                .empty(!isHit)
                .experimentName("计划维度实验")
                .experimentCode(salt)
                .level(3)
                .build();

            // 打印实验日志
            experimentLog.print();

            return isHit;
        } catch (Throwable e) {
            log.error("experiment|tar_salt_ab|error|{}|{}|{}", userId, salt, e.getMessage());
            log.error("experiment|tar_salt_ab|error", e);
        }

        return true;
    }

    public static boolean isHitGray(long userId){

        try {
            // 是否灰度全量
            boolean enableGray = ExperimentSdkConfig.getBooleanValue("experiment.global.gray.full", false);
            if (enableGray) {
                return true;
            }

            // 灰度比例
            int grayRate = ExperimentSdkConfig.getIntValue("experiment.global.gray.rate", 10);
            String graySalt = ExperimentSdkConfig.getValue("experiment.global.gray.salt", "graySalt");

            int rate = MurMurHashUtil.routing(userId, graySalt);

            return rate < (grayRate * 10000);
        } catch (Throwable e) {
            log.error("experiment|isHitGray|error|{}|{}", userId, e.getMessage());
            log.error("experiment|isHitGray", e);
        }

        // 兜底所有不在灰度中
        return false;
    }

    /**
     * 通过实验code获取实验
     *
     * @param experimentCode 实验code
     * @return 实验
     */
    private static Experiment getExperiment(String experimentCode) {
        //这里的配置应该从diamond中获取、
        List<Experiment> experiments = new ArrayList<>();
        Assert.notEmpty(experiments, "NOT_FOUND_EXPERIMENT_CONFIG", "未找到实验配置");

        for (Experiment experiment : experiments) {
            if (experimentCode.equals(experiment.getExperimentCode())) {
                return experiment;
            }
        }

        throw new BizException("NOT_MATCH_EXPERIMENT", "未匹配到实验");
    }
}
