package com.example.demo.leetcode.types.array;

import java.util.Arrays;

/**
 * 除数组之外自身的乘积
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * @author zaochun.zjw
 * @date 2024/4/9
 */
public class Medium238除自身以外数组的乘积 {

    public static void main(String[] args) {
        Arrays.stream(productExceptSelf(new int[]{-1,1,0,-3,3})).forEach(System.out::println);
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] preNum = new int[nums.length];
        int[] afterNum = new int[nums.length];
        preNum[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            preNum[i] = nums[i - 1] * preNum[i - 1];
        }

        afterNum[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            afterNum[i] = afterNum[i + 1] * nums[i + 1];
        }

        for(int i = 0;i<nums.length;i++){
            nums[i] = preNum[i] * afterNum[i];
        }

        return nums;
    }
}
