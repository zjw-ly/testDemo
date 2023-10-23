package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * Related Topics
 * 数组
 * 双指针
 * 排序
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 */
public class Medium16最接近的三数之和 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int returnVale = Integer.MAX_VALUE;;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right ){
                if(Math.abs(nums[i] + nums[left] + nums[right] - target) < min){
                    min = Math.abs(nums[i] + nums[left] + nums[right] - target);
                    returnVale = nums[i] + nums[left] + nums[right];
//                    while (left < right && nums[left] == nums[++left]);
//                    while (left < right && nums[right] == nums[--right]);
                }

                if(nums[i] + nums[left] + nums[right] - target > 0){
                    right --;
                }else{
                    left ++;
                }
            }
        }

        return returnVale;
    }
}
