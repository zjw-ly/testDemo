package com.example.demo.leetcode.base.sort;

import java.util.Arrays;

/**
 * 二分排序
 *
 * @author zaochun.zjw
 * @date 2023/10/23
 */
public class TwoPointSort {

    public static void main(String[] args) {
        int[] num = new int[]{3, 34, 5, 67, 1, 43, 4, 56};
        sort(num);
        Arrays.stream(num).forEach(it -> System.out.println(it));
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currency = array[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (currency < array[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (int j = i - 1; j >= low; j--) {
                array[j + 1] = array[j];
            }

            array[low] = currency;
        }

    }


    public static void binaryInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];  // 当前要插入的元素
            int low = 0;  // 已排序区间的起始位置
            int high = i - 1;  // 已排序区间的结束位置

            // 二分查找找到插入位置
            while (low <= high) {
                int mid = (low + high) / 2;
                if (current < array[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // 将大于current的元素后移
            for (int j = i - 1; j >= low; j--) {
                array[j + 1] = array[j];
            }

            // 插入current到正确位置
            array[low] = current;
        }
    }
}
