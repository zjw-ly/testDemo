package com.example.test;

import java.util.Objects;

/**
 * @author zaochun.zjw
 * @date 2024/6/14
 */
public class Test {

    // 散列函数
    public static int hashFunction(int userId, int numberOfBuckets) {
        return Objects.hash(userId) % numberOfBuckets;
    }

    public static void main(String[] args) {
        int userId = 12345; // 示例用户ID
        int numberOfBuckets = 10; // 假设我们需要将用户ID分散到10个桶中

        int bucketId = hashFunction(userId, numberOfBuckets);
        System.out.println("用户ID " + userId + " 被分配到桶 " + bucketId);
    }
}
