package com.example.demo.abprower;

import com.google.common.hash.Hashing;

/**
 * hash 随机打散 生成工具类
 *
 * @author zaochun.zjw
 * @date 2023/5/26
 */
public class MurmurHashUtil {

    public MurmurHashUtil() {
    }

    /**
     * 散列路由
     *
     * @param userId 用户id
     * @param salt   加盐
     * @return 路由
     */
    public static int routing(long userId, String salt) {
        byte[] hashKey;
        try {
            //加盐得出不同的打散效果
            hashKey = (userId + salt).getBytes("utf-8");
        } catch (Throwable var6) {
            throw new RuntimeException(var6.getCause());
        }

        int hash = guavaMurmurHash3_32(hashKey);
        int keyHashCode = Math.abs(hash);
        return keyHashCode % 1000000;
    }

    /**
     * 获取hash值
     *
     * @param key key值
     * @return hash值
     */
    private static int guavaMurmurHash3_32(byte[] key) {
        int seed = 1526958062;

        //md5加密算法
        //byte[] bytes = (seed + "").getBytes();
        //Hashing.hmacMd5(bytes).hashBytes(key).asInt();

        return Hashing.murmur3_32(seed).hashBytes(key).asInt();
    }
}
