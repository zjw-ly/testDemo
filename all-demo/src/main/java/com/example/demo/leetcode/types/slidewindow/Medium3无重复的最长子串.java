package com.example.demo.leetcode.types.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author zaochun.zjw
 * @date 2024/3/25
 */
public class Medium3无重复的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcdb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        int left = 0;
        int right = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int max = 1;
        while (right <= s.length() - 1) {
            String substring = s.substring(left, right);
            if (!substring.contains(String.valueOf(s.charAt(right)))) {
                map.put(s.charAt(right), right);
                max = Math.max(right - left + 1, max);
            } else {
                Integer integer = map.get(s.charAt(right));
                left = integer + 1;
                map.put(s.charAt(right), right);
            }

            right++;
        }

        return max;
    }
}
