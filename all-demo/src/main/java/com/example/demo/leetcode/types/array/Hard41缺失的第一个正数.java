package com.example.demo.leetcode.types.array;

/**
 * 缺失的正数
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * <p>
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * <p>
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 *
 * @author zaochun.zjw
 * @date 2024/4/9
 */
public class Hard41缺失的第一个正数 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositiveTest(new int[]{3, 4, -1, 1}));
    }

    public static int firstMissingPositiveTest(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            }

            int num = nums[i];
            while (num <= nums.length && num > 0 && nums[num - 1] != num) {
                int nextJ = nums[num - 1];
                nums[num - 1] = num ;
                num = nextJ;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static int firstMissingPositive(int[] nums) {
        boolean[] len = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0) {
                len[nums[i] - 1] = true;
            }
        }

        for (int i = 0; i < len.length; i++) {
            if (!len[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
