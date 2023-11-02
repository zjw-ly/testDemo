package com.example.demo.leetcode;

import java.util.*;

/**
 * 字母异位词分组
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * @author zaochun.zjw
 * @date 2023/10/30
 */
public class Medium49字母异位词分组 {

    public static void main(String[] args) {
        Arrays.asList();
        Medium49字母异位词分组 medium49字母异位词分组 = new Medium49字母异位词分组();

        medium49字母异位词分组.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).stream().forEach(it -> {
            System.out.print("排列");
            it.stream().forEach(that -> {
                System.out.print(that + ",");
            });
            System.out.println("");
        });
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }

        if (strs.length == 1) {
            res.add(Arrays.asList(strs[0]));
            return res;
        }

        Map<String, List<String>> has = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = combineChars(chars);
            if (!has.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(strs[i]);
                has.put(str, arrayList);
            } else {
                List<String> list = has.get(str);
                list.add(strs[i]);
            }
        }

        for (List<String> str : has.values()) {
            res.add(str);
        }

        return res;
    }

    public String combineChars(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char s : chars) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}
