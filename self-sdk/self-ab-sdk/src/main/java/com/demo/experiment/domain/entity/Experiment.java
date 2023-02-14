package com.demo.experiment.domain.entity;

import lombok.Data;

import java.util.List;

/**
 * 实验
 *
 * @author zaochun.zjw
 * @date 2023/2/10
 */
@Data
public class Experiment {

    /** 实验code */
    private String experimentCode;

    /** 实验名称 */
    private String experimentName;

    /** 父级实验code */
    private String parentExperimentCode;

    /** 父级分桶code */
    private String parentBucketCode;

    /** 分流因子 */
    private String salt;

    /** 是否轮换分流因子 */
    private boolean rotateSalt;

    /** 轮换因子值 */
    private int rotateVal;

    /** 层级 */
    private int level;

    /** 分桶 */
    private List<Bucket> buckets;

    public Bucket find(long userId){
        return new Bucket();
    }
}
