package com.demo.experiment.utils;

import com.google.common.hash.Hashing;

/**
 * hash 工具类
 *
 * @author zaochun.zjw
 * @date 2023/2/13
 */
public class MurMurHashUtil {

    /**
     * 解析路由key
     *
     * @param userId 用户id
     * @param salt   分流因子
     * @return
     */
    public static int routing(long userId, String salt) {
        byte[] hashKey;
        try {
            hashKey = (userId + salt).getBytes("utf-8");
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable.getCause());
        }

        int hash = guavaMurmurHash3_32(hashKey);
        int keyHashCode = Math.abs(hash);

        return keyHashCode % 1000000;
    }

    private static int guavaMurmurHash3_32(byte[] key) {
        int seed = 1526958062;
        return Hashing.murmur3_32(seed).hashBytes(key).asInt();
    }
}
