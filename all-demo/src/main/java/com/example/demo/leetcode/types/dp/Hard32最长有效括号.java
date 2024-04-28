package com.example.demo.leetcode.types.dp;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号
 * 子串
 * 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * <p>
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * <p>
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 *
 * @author zaochun.zjw
 * @date 2024/4/12
 */
public class Hard32最长有效括号 {

    //()(() 2

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }

            if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    nums[pop] = 1;
                    nums[i] = 1;
                }
            }
        }

        int max = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (nums[i] == 1) {
                tmp++;
            } else {
                max = Math.max(max, tmp);
                tmp = 0;
            }
        }

        max = Math.max(max, tmp);
        return max;
    }
}
