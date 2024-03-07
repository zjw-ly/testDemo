package com.example.demo.leetcode.types.array;

/**
 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 子数组是数组中的一个连续部分。
 示例 1：

 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 输出：6
 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 示例 2：

 输入：nums = [1]
 输出：1
 示例 3：

 输入：nums = [5,4,-1,7,8]
 输出：23
 *
 * @author zaochun.zjw
 * @date 2024/3/7
 */
public class Easy53最大子数组和 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }

    public static int maxSubArray(int[] nums) {
        int[] arr = new int[nums.length];
        int max = arr[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(arr[i-1] >0){
                arr[i] = arr[i-1] + nums[i];
            }else
                arr[i] = nums[i];

            max = Math.max(arr[i],max);
        }

        return max;
    }
}
