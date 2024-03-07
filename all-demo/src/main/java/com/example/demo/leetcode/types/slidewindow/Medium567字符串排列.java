package com.example.demo.leetcode.types.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串排列
 *
 * @author zaochun.zjw
 * @date 2024/3/6
 */
public class Medium567字符串排列 {

    public static void main(String[] args) {
        System.out.println(containSort("hello", "ooolleoooleh"));
    }

    public static boolean containSort(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char cs : s1.toCharArray()) {
            need.put(cs, need.getOrDefault(cs, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char rightCr = s2.charAt(right);
            right++;
            if (need.containsKey(rightCr)) {
                window.put(rightCr, window.getOrDefault(rightCr, 0) + 1);
                if (need.get(rightCr).equals(window.get(rightCr))) {
                    valid++;
                }
            }

            while(right - left >= s1.length()){
                char leftCr = s2.charAt(left);
                left++;
                if(valid == need.size()){
                    return true;
                }

                if(need.containsKey(leftCr)){
                    if(need.get(leftCr).equals(window.get(leftCr))){
                        valid--;
                    }

                    window.put(leftCr,window.get(leftCr)-1);
                }
            }
        }
        return false;
    }
}
