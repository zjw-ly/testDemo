package com.example.demo.leetcode.types.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词数组
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * Related Topics
 * 哈希表
 * 字符串
 * 滑动窗口
 *
 * @author zaochun.zjw
 * @date 2024/3/6
 */
public class Medium438字母异位词数组 {

    public static List<Integer> findOther(String str, String sub) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char subCr : sub.toCharArray()) {
            need.put(subCr, need.getOrDefault(subCr, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < str.length()) {
            char rightCr = str.charAt(right);
            right++;
            if (need.containsKey(rightCr)) {
                window.put(rightCr, window.getOrDefault(rightCr, 0) + 1);
                if (need.get(rightCr).equals(window.get(rightCr))) {
                    valid++;
                }
            }

            while (right - left >= sub.length()) {
                char leftStr = str.charAt(left);
                if (need.size() == valid && !sub.equals(str.substring(left, right))) {
                    res.add(left);
                }
                left++;
                if (need.containsKey(leftStr)) {
                    if (need.get(leftStr).equals(window.get(leftStr))) {
                        valid--;
                    }
                    window.put(leftStr, window.get(leftStr) - 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findOther("cbaebabacd", "abc"));
    }
}
