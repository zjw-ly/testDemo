package com.example.demo.leetcode.types.slidewindow.l75;

/**
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * 示例 2：
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 *
 * @author zaochun.zjw
 * @date 2024/5/29
 */
public class Easy643子数组最大平均数I {

    public double findMaxAverage(int[] nums, int k) {
        if (k > nums.length) {
            return 0;
        }

        int left = 0;
        int right = k - 1;
        double res = 0;
        for (int i = 0; i < k; i++) {
            res += nums[i];
        }

        double tmp = res;
        while (right < nums.length) {
            if (right == nums.length - 1) {
                break;
            }

            tmp = tmp - nums[left] + nums[right + 1];
            if (tmp > res) {
                res = tmp;
            }

            left++;
            right++;
        }

        return res / k;
    }
}
