package com.demo.experiment.domain.entity;

import com.demo.experiment.exception.Assert;
import com.demo.experiment.exception.BizException;
import com.demo.experiment.utils.MurMurHashUtil;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Bucket find(long userId) {
        Assert.notEmpty(this.buckets, "NOT_FOUND_BUCKETS", String.format("未找到实验分桶", this.experimentCode));

        //判断是否在分桶白名单中，存在直接返回该桶
        Optional<Bucket> optional = findByWhiteUser(userId);
        if (optional.isPresent()) {
            return optional.get();
        }

        String salt = this.resoleSalt();

        int val = MurMurHashUtil.routing(userId, salt);
        int totalRate = 0;

        for (Bucket bucket : this.buckets) {
            //totalRate跟加密算法的精度对齐，因此需要 * 分桶比例（整数 如5，15） * 10000
            totalRate += (bucket.getRate() * 10000);

            if (val < totalRate) {
                return bucket;
            }
        }

        throw new BizException("NOT_MATCH_BUCKET", String.format("未匹配分桶，请检查实验%s分桶配置", this.experimentCode));
    }

    /**
     * 查询用户是否在分桶白名单中
     *
     * @param userId 用户id
     * @return 分桶
     */
    private Optional<Bucket> findByWhiteUser(long userId) {
        return this.buckets.stream().filter(l -> l.inWhiteUsers(userId)).findFirst();
    }

    /**
     * 获取分流因子
     *
     * @return 分流因子
     */
    private String resoleSalt() {
        if (rotateSalt) {
            // 轮换因子 代表重新修改分流分桶的一个手段
            int val = rotateVal > 0 ? rotateVal : 3;
            // 这里对盐值进行每三个月的重新修正 代表了每三个月分桶流量就会重新根据hash函数打散一次
            int randomSalt = (LocalDateTime.now().getMonthValue() - 1) / val;

            return this.salt + randomSalt;
        }

        return salt;
    }
}
