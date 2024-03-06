package com.example.demo.leetcode.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zaochun.zjw
 * @date 2024/3/5
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getRepeatLength("abcabcdb"));
    }

    public static int getRepeatLength(String str) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int start = 0;
        int ans = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.containsKey(chars[i])) {
                start = Math.max(start, hashMap.get(chars[i]));
            }
            ans = Math.max(ans, i - start + 1);
            hashMap.put(chars[i], i +1);
        }

        return ans;
    }
}
