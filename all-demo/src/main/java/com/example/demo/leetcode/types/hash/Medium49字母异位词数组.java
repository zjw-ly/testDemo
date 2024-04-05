package com.example.demo.leetcode.types.hash;

import java.util.*;

/**
 * 字母异位词数组
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * @author zaochun.zjw
 * @date 2024/4/2
 */
public class Medium49字母异位词数组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            String sourceStr = toSource(str);
            ArrayList<String> list = map.getOrDefault(sourceStr, new ArrayList<>());
            list.add(str);
            map.put(sourceStr, list);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    public String toSource(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        StringBuilder stringBuilder = new StringBuilder();
        for(Character cs : chars){
            stringBuilder.append(cs);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Medium49字母异位词数组 medium49字母异位词数组 = new Medium49字母异位词数组();
        List<List<String>> lists = medium49字母异位词数组.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        System.out.println(medium49字母异位词数组.toSource("eat"));
    }
}
