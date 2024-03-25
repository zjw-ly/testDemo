package com.example.demo.leetcode.types.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * <p>
 * 示例 2：
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 *
 * @author zaochun.zjw
 * @date 2024/3/20
 */
public class Medium673划分字母区间 {

    public static void main(String[] args) {
        System.out.println(partitionLabels("eccbbbbdec"));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
        }

        for (int i = 0; i < s.length(); ) {
            char cs = s.charAt(i);
            int loc = map.get(cs);
            List<Character> csList = new ArrayList<>(cs);
            for (int j = i; j < loc; j++) {
                char csNext = s.charAt(j);
                if (!csList.contains(csNext)) {
                    csList.add(csNext);
                    loc = Math.max(loc, map.get(csNext));
                }
            }
            res.add(loc - i + 1);
            i = loc + 1;
        }

        return res;
    }
}
