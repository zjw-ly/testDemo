package com.example.demo.leetcode.types.stack;

/**
 * @author zaochun.zjw
 * @date 2024/3/19
 */
public class ZMedium84柱状图中最大的矩形 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 4}));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0];
        }

        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j >= 0; j--) {
                int len = i - j + 1;
                minHeight = Math.min(minHeight, heights[j]);
                max = Math.max(max, len * minHeight);
            }
        }

        return max;
    }
}
