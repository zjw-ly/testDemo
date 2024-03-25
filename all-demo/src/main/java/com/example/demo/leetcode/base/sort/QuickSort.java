package com.example.demo.leetcode.base.sort;

import java.util.Arrays;

/**
 * 快速排序 递归依次找到基准元素应该在整个数组中的位置，最左元素作为基准元素，动态调整所在位置
 *
 * @author zaochun.zjw
 * @date 2023/10/23
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 34, 5, 67, 1, 43, 4, 56};
        qs(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(it -> System.out.println(it));
    }

    public static void qs(int[] num, int start, int end) {
        if (start < end) {
            int one = findOne(num, start, end);
            qs(num, start, one - 1);
            qs(num, one + 1, end);
        }
    }

    public static int findOne(int[] num, int start, int end) {
        int val = num[start];
        int left = start;
        int right = end;

        while (left < right) {
            // 先操作右侧指针是用来保证 在两个指针相遇时 数据小于最左侧基准数字
            while (left < right && val <= num[right]) {
                right--;
            }

            while (left < right && val >= num[left]) {
                left++;
            }

            if (left >= right) {
                break;
            }

            int tmp = num[left];
            num[left] = num[right];
            num[right] = tmp;
        }

        // 将相遇的元素与基准元素分开
        num[start] = num[left];
        num[left] = val;
        return left;
    }
}
