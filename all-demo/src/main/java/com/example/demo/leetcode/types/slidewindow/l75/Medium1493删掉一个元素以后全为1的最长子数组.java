package com.example.demo.leetcode.types.slidewindow.l75;

/**
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * <p>
 * <p>
 * 提示 1：
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 *
 * @author zaochun.zjw
 * @date 2024/5/29
 */
public class Medium1493删掉一个元素以后全为1的最长子数组 {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,0,1,1}));
    }

    public static int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                left = i;
                right = i;
                break;
            }
        }

        int tmpLength = 0;
        int lastIndex = left;
        while (right < nums.length) {
            if (nums[right] != 0) {
                right++;
                continue;
            } else {
                lastIndex = right;
                right = right + 1;
                while (right < nums.length && nums[right] != 0) {
                    right++;
                }

                tmpLength = Math.max(tmpLength, right - left - 1);
                left = lastIndex + 1;
            }
        }

        return Math.max(tmpLength,left ==0 ? right - left - 1 : right -left);
    }
}
