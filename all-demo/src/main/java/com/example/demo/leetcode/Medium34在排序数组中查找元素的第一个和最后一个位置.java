package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @author zaochun.zjw
 * @date 2023/10/23
 */
public class Medium34在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        Arrays.stream(searchRange(new int[]{2,2}, 2)).forEach(it -> System.out.println(it));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            }
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int start = mid;
                int end = mid;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }

                while (end <= nums.length - 1 && nums[end] == target) {
                    end++;
                }

                if (start + 1 < end - 1) {
                    return new int[]{start + 1, end - 1};
                } else {
                    return new int[]{end - 1, start + 1};
                }
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
