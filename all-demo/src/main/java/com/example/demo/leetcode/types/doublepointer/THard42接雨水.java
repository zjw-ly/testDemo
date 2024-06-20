package com.example.demo.leetcode.types.doublepointer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * @author zaochun.zjw
 * @date 2024/4/2
 */
public class THard42接雨水 {

    public static int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public static int trapDp(int[] height) {
        int[] leftDp = new int[height.length];
        int[] rightDp = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftDp[i] = Math.max(leftDp[i - 1], height[i - 1]);
        }

        for (int j = height.length - 2; j >= 0; j--) {
            rightDp[j] = Math.max(rightDp[j + 1], height[j + 1]);
        }

        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(leftDp[i], rightDp[i]);
            if (height[i] < min) {
                res += (min - height[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(num));
        System.out.println(trapDp(num));
    }
}
