package com.example.demo.leetcode.types.doublepointer;

import java.util.Arrays;

/**
 * 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * @author zaochun.zjw
 * @date 2024/4/2
 */
public class Easy283移动零 {

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (left < nums.length && right < nums.length) {
            while (left < nums.length && nums[left] != 0) {
                left++;
            }

            right = left;
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            if (left > right || right >= nums.length || left >= nums.length) {
                break;
            }

            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right++;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 0, 1};
        moveZeroes(num);
        Arrays.stream(num).forEach(System.out::println);
    }


}
