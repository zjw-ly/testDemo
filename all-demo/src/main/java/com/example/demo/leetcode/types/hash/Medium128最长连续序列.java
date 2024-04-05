package com.example.demo.leetcode.types.hash;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * @author zaochun.zjw
 * @date 2024/4/2
 */
public class Medium128最长连续序列 {

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        int[] sum = new int[nums.length];
        sum[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = 1;
            if (nums[i] == nums[i - 1] + 1) {
                sum[i] = sum[i - 1] + 1;
                max = Math.max(max, sum[i]);
            }

            if(nums[i] == nums[i - 1]){
                sum[i] = sum[i - 1];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
