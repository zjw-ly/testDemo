package com.example.demo.leetcode.top;

/**
 * 最长子回文
 * <p>
 * * 给你一个字符串 s，找到 s 中最长的回文子串。
 * *
 * * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * *
 * * 示例 1：
 * *
 * * 输入：s = "babad"
 * * 输出："bab"
 * * 解释："aba" 同样是符合题意的答案。
 * * 示例 2：
 * *
 * * 输入：s = "cbbd"
 * * 输出："bb"
 * * 提示：
 * *
 * * 1 <= s.length <= 1000
 * * s 仅由数字和英文字母组成
 *
 * @author zaochun.zjw
 * @date 2023/10/18
 */
public class FMedium5最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {
        char[] actor = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (actor[i] != actor[j]) {
                    dp[i][j] = false;
                } else {
                    // 动态规划临界点
                    if (i - j < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }

                if (dp[i][j] && i - j + 1 > max) {
                    max = i - j + 1;
                    maxLeft = j;
                    maxRight = i;
                }
            }
        }

        return s.substring(maxLeft, maxRight + 1);
    }
}
