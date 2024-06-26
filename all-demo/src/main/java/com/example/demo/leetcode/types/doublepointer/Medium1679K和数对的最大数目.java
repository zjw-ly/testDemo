package com.example.demo.leetcode.types.doublepointer;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回你可以对数组执行的最大操作数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 *
 * @author zaochun.zjw
 * @date 2024/5/28
 */
public class Medium1679K和数对的最大数目 {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;

        int leftIndex =0;
        int rightIndex =nums.length - 1;
        while (leftIndex < rightIndex) {
            if (nums[leftIndex] + nums[rightIndex] == k) {
                leftIndex++;
                rightIndex--;
                res++;
            } else if (nums[leftIndex] + nums[rightIndex] > k) {
                rightIndex--;
            } else if (nums[leftIndex] + nums[rightIndex] < k) {
                leftIndex++;
            }
        }

        return res;
    }
}
