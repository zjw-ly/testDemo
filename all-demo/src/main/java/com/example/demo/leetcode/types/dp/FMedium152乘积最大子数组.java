package com.example.demo.leetcode.types.dp;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author zaochun.zjw
 * @date 2024/3/26
 */
public class FMedium152乘积最大子数组 {

    public static void main(String[] args) {
        System.out.println(maxProductText(new int[]{3, -1, 4}));
    }

    public static int maxProductText(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        int ans = maxF[0];
        for (int i = 1; i < length; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            ans = Math.max(ans, maxF[i]);
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], nums[i] * maxF[i - 1]));
        }

        return ans;
    }
}
