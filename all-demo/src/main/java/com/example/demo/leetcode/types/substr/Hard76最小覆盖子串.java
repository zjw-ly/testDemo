package com.example.demo.leetcode.types.substr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zaochun.zjw
 * @date 2024/3/5
 */
public class Hard76最小覆盖子串 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // 输出应该是"BANC"
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        int length = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char tmp = s.charAt(right);
            right++;

            // 右侧窗口开始处理
            if (need.containsKey(tmp)) {
                window.put(tmp, window.getOrDefault(tmp, 0) + 1);
                if (window.get(tmp).equals(need.get(tmp))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < length) {
                    length = right - left;
                    start = left;
                }

                char rTmp = s.charAt(left);
                left++;
                if (need.containsKey(rTmp)) {
                    if (need.get(rTmp)==window.get(rTmp)) {
                        valid--;
                    }
                    window.put(rTmp,window.get(rTmp)-1);
                }
            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
