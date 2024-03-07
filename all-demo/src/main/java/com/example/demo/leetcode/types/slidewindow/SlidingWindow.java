package com.example.demo.leetcode.types.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口框架
 *
 * @author zaochun.zjw
 * @date 2024/3/5
 */
public class SlidingWindow {


    public static void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            // ...

            /*** debug 输出的位置 ***/
            System.out.printf("window: [%d, %d)\n", left, right);
            /********************/

            // 判断左侧窗口是否要收缩
            boolean needsShrink = false; // 你需要根据实际情况来设置这个条件
            while (needsShrink) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
            }
        }
    }
}
