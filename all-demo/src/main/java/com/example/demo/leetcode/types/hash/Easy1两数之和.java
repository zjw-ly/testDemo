package com.example.demo.leetcode.types.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @author zaochun.zjw
 * @date 2024/4/2
 */
public class Easy1两数之和 {

    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{3,2,4}, 6)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(target - nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            if (hashMap.containsKey(nums[j])) {
                Integer integer = hashMap.get(nums[j]);
                if (integer != j) {
                    return new int[]{integer, j};
                }
            }
        }

        return new int[]{};
    }
}
