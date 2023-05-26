package com.example.demo.abprower;

import com.example.demo.abprower.bucket.Bucket;
import com.example.demo.exception.BizException;
import lombok.Data;

import java.util.*;

/**
 * ab测试demo
 *
 * @author zaochun.zjw
 * @date 2023/5/25
 */
@Data
public class AbDemo {

    /** 比例总数 */
    private Long total = 10000L;

    private List<Bucket> buckets;


    public List<Long> userIdList = new ArrayList<>();

    /**
     * 随机生成10w个用户id
     */
    public void generateUserIds() {
        Random random = new Random();
        random.setSeed(1000);

        while (userIdList.size() <= 100000) {
            int anInt = random.nextInt();
            userIdList.add(Long.valueOf(anInt));
        }
    }

    /**
     * 生成两个比例桶
     */
    public void generateBuckets() {
        Bucket experiment = new Bucket();
        experiment.setRate(30);

        Bucket originalBucket = new Bucket();
        originalBucket.setRate(70);
        originalBucket.setEmpty(true);

        buckets = Arrays.asList(experiment, originalBucket);
    }

    /**
     * 验证用户属于哪个桶
     *
     * @param userId 用户id
     * @return 桶
     */
    public boolean shuntData(long userId) {

        String salt = "1000";
        int val = MurmurHashUtil.routing(userId, salt);
        int totalRate = 0;
        Iterator var7 = this.buckets.iterator();

        Bucket bucket;
        do {
            if (!var7.hasNext()) {
                throw new BizException("NOT_MATCH_BUCKET", String.format("未匹配分桶，请检查实验分桶配置"));
            }

            bucket = (Bucket) var7.next();
            totalRate += bucket.getRate() * 10000;
        } while (val >= totalRate);

        return bucket.isEmpty();
    }

    public static void main(String[] args) {
        AbDemo abDemo = new AbDemo();

        abDemo.generateUserIds();
        abDemo.generateBuckets();

        List<Long> experimentUserId = new ArrayList<>();
        List<Long> ori = new ArrayList<>();

        List<Long> userIdList1 = abDemo.getUserIdList();
        for (int i = 0; i < userIdList1.size(); i++) {
            if (abDemo.shuntData(userIdList1.get(i))) {
                ori.add(userIdList1.get(i));
            } else {
                experimentUserId.add(userIdList1.get(i));
            }
        }

        System.out.println("实验桶大致比例" + experimentUserId.size() * 1000 / userIdList1.size());
        System.out.println("对照桶大致比例" + ori.size() * 1000 / userIdList1.size());
    }
}
