package com.example.demo.leetcode.test;

import java.util.Arrays;

/**
 * * 轮转数组
 * * <p>
 * * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * * <p>
 * * <p>
 * * <p>
 * * 示例 1:
 * * <p>
 * * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * * 输出: [5,6,7,1,2,3,4]
 * * 解释:
 * * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * * 示例 2:
 * * <p>
 * * 输入：nums = [-1,-100,3,99], k = 2
 * * 输出：[3,99,-1,-100]
 * * 解释:
 * * 向右轮转 1 步: [99,-1,-100,3]
 * * 向右轮转 2 步: [3,99,-1,-100]
 * * <p>
 * * 提示：
 * * <p>
 * * 1 <= nums.length <= 105
 * * -231 <= nums[i] <= 231 - 1
 * * 0 <= k <= 105
 * * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * @author zaochun.zjw
 * @date 2024/3/5
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int[] num = new int[]{1,2,3,4,5,6,7};
        test.rotate(num,3);
        Arrays.stream(num).forEach(System.out::println);
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k > 0) {
            reverse(nums, nums.length - k, nums.length - 1);
            reverse(nums, 0, nums.length - k - 1);
            reverse(nums, 0, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
