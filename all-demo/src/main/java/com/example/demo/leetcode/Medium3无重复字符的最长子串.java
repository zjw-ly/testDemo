package com.example.demo.leetcode;

import java.util.HashMap;

/**
 * 无重复字符的最长子串 (滑动窗口标记启示、结束位置)
 *
 * @author zaochun.zjw
 * @date 2023/10/18
 */
public class Medium3无重复字符的最长子串 {

    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */

    /**
     * 获取无重复最长子串
     *
     * @param str 字符
     * @return 子串
     */
    public static int getRepeatLength(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            end = i;

            if (map.containsKey(chars[end]) && start <= map.get(chars[end])) {
                start = map.get(chars[end]) + 1;
            } else {
                int a = end - start + 1;
                if (a > max) {
                    max = a;
                }
            }
            map.put(chars[i], i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(getRepeatLength("abcabcbb"));
    }
}
