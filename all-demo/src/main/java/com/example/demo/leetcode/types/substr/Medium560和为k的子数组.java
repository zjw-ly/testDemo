package com.example.demo.leetcode.types.substr;

/**
 * 和为k的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * @author zaochun.zjw
 * @date 2024/3/7
 */
public class Medium560和为k的子数组 {

    public static int subarraySum(int[] nums, int k) {
        int subAll = 0;
        for(int i = 0;i<nums.length;i++){
            int tmp = 0;
            for(int x = i;x<nums.length;x++){
                tmp += nums[x];
                if(x == k){
                    subAll++;
                }
            }
        }

        return subAll;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }
}
