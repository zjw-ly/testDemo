package com.example.demo.leetcode.test;

import java.util.Arrays;

/**
 * 轮转数组
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * @date 2024/3/5
 */
public class Test {

    public static void main(String[] args) {
        String str = "WB01999339\n" +
            "WB01999333\n" +
            "WB01999340\n" +
            "WB01999345\n" +
            "WB01999344\n" +
            "WB01999347\n" +
            "WB01999334\n" +
            "WB01999348\n" +
            "WB01999336\n" +
            "WB01999342\n" +
            "WB02005293\n" +
            "WB02005285\n" +
            "WB02005288\n" +
            "WB02005289\n" +
            "WB02005291\n" +
            "WB02005286\n" +
            "WB02005287\n" +
            "WB02005292\n" +
            "WB01949123\n" +
            "WB01949129\n" +
            "WB02005290\n" +
            "wb01546105\n" +
            "WB01994151\n" +
            "WB01994153\n" +
            "WB01994158\n" +
            "WB01994156\n" +
            "WB01994150\n" +
            "WB01994154\n" +
            "WB01994159\n" +
            "WB01994152\n" +
            "WB01994155\n" +
            "WB01122485\n" +
            "WB01994157\n" +
            "WB872180\n" +
            "WB01771662\n" +
            "WB02006475\n" +
            "WB01771642\n" +
            "WB01832006\n" +
            "WB02006477\n" +
            "WB02006478\n" +
            "WB02006476";

        System.out.println(str.replace("\n",","));

    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int tmp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = tmp;
            startIndex++;
            endIndex--;
        }
    }
}