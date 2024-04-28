package com.example.demo.leetcode.types.skill;

import java.util.Arrays;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <p>
 * 示例 1 ：
 * 输入：nums = [2,2,1]
 * 输出：1
 * <p>
 * 示例 2 ：
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * <p>
 * 示例 3 ：
 * 输入：nums = [1]
 * 输出：1
 *
 * @author zaochun.zjw
 * @date 2024/4/23
 */
public class Easy136只出现一次的数字 {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index] == nums[index + 1]) {
                index += 2;
            } else {
                return nums[index];
            }
        }
        return nums[nums.length - 1];
    }

}
