package com.example.demo.leetcode.types.dpmore;

/**
 * 给你一个字符串 s，找到 s 中最长的回文
 * 子串
 * 。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * @author zaochun.zjw
 * @date 2024/4/15
 */
public class Medium5最长回文子串 {

    public static void main(String[] args) {
        Medium5最长回文子串 tmp = new Medium5最长回文子串();
        System.out.println(tmp.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        int max = 1;
        String strMax = "";
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (isHuiWen(str)) {
                    max = Math.max(max, str.length());
                    if (max == str.length()) {
                        strMax = str;
                    }
                }
            }
        }

        return strMax;
    }

    public boolean isHuiWen(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }

        if (str.length() == 2) {
            return str.charAt(0) == str.charAt(1);
        }

        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindromeDP(String s) {
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
