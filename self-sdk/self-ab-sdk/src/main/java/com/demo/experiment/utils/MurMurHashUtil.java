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
            // 第一步 变成字节序列
            hashKey = (userId + salt).getBytes("utf-8");
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable.getCause());
        }

        int hash = guavaMurmurHash3_32(hashKey);
        int keyHashCode = Math.abs(hash);

        //这里是为了保持精度 整个流量的虚拟份数 设置为 100 * 10000
        return keyHashCode % 1000000;
    }

    private static int guavaMurmurHash3_32(byte[] key) {
        int seed = 1526958062;
        //2. 使用给定的种子值返回实现 32 位 murmur3 算法的哈希函数
        //3. 使用该hash函数得出：一个hashcode ，并转化为int值
        return Hashing.murmur3_32(seed).hashBytes(key).asInt();
    }
}
