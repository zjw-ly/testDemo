package com.example.demo.leetcode.types.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词数组
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
