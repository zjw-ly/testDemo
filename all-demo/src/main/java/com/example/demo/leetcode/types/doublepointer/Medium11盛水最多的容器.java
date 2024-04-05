package com.example.demo.leetcode.types.doublepointer;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 *
 * @author zaochun.zjw
 * @date 2024/4/2
 */
public class Medium11盛水最多的容器 {

    public static void main(String[] args) {
        int[] num = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(num));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int minBottle = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * minBottle);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
