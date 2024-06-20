package com.example.demo.leetcode.all;

/**
 * 出现最频繁的偶数
 *
 * @author zaochun.zjw
 * @date 2023/4/13
 */
public class Easy2404出现最频繁的偶数 {

    public static int mostFrequentEven(int[] nums) {

        // 不存在偶数元素返回 -1
        int ans = -1;

        // 出现频率的下限，优于-1，
        int maxFrequent = 0;

        int[] arr = new int[50001];

        for (int num : nums) {

            // 优化点：位操作判断是否为偶数
            if ((num & 1) == 0) {

                // 1. 先计数加1。 优化点：位操作计算下标
                int freq = ++arr[num >> 1];

                // 2. 判断是否需要更新偶数出现的最大频率，及对应的偶数
                ans = (freq > maxFrequent || (freq == maxFrequent && num < ans)) ? num : ans;
                maxFrequent = freq > maxFrequent ? freq : maxFrequent;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 2, 4, 4, 1};
        System.out.println(mostFrequentEven(a));
    }
}
