package com.example.demo.leetcode.base.sort;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 冒泡排序
 *
 * @author zaochun.zjw
 * @date 2023/10/23
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3,34,5,67,1,43,4,56};

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        Arrays.stream(nums).forEach(it -> System.out.println(it));

    }
}
