package com.example.demo.leetcode.types.twosearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @author zaochun.zjw
 * @date 2024/3/18
 */
public class Medium34在排序数组中查找元素的第一个位置及最后一个位置 {

    public static void main(String[] args) {
        Medium34在排序数组中查找元素的第一个位置及最后一个位置 tmp = new Medium34在排序数组中查找元素的第一个位置及最后一个位置();
        System.out.println(tmp.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            }
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] > target || nums[right] < target) {
                return new int[]{-1, -1};
            }

            if (nums[left] == target && nums[right] == target) {
                while (nums[left] == target && left > 0) {
                    left--;
                }

                while (nums[right] == target && right < nums.length - 1) {
                    right++;
                }

                if (left + 1 < right - 1) {
                    return new int[]{left + 1, right - 1};
                } else {
                    return new int[]{right - 1, left + 1};
                }
            }

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
