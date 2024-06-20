package com.example.demo.leetcode.all;

/**
 * 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 */
public class Easy14最长公共前缀 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        int minLength = strs[0].length();
        String minStr = strs[0];

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                minStr = strs[i];
            }
        }

        char[] minChars = minStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < minChars.length; j++) {

            int i = 0;
            for (; i < strs.length; i++) {
                if (!strs[i].substring(j, j + 1).equals(String.valueOf(minChars[j]))) {
                    return stringBuilder.toString();
                }
            }

            if (i == strs.length) {
                stringBuilder.append(minChars[j]);
            }
        }

        return stringBuilder.toString();
    }
}
