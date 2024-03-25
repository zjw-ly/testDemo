package com.example.demo.leetcode.types.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  * 电话号码的数字字母组合
 *  * <p>
 *  * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *  * <p>
 *  * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *  * 示例 1：
 *  * <p>
 *  * 输入：digits = "23"
 *  * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *  * 示例 2：
 *  * <p>
 *  * 输入：digits = ""
 *  * 输出：[]
 *  * 示例 3：
 *  * <p>
 *  * 输入：digits = "2"
 *  * 输出：["a","b","c"]
 *  * 提示：
 *  * <p>
 *  * 0 <= digits.length <= 4
 *  * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @author zaochun.zjw
 * @date 2024/3/14
 */
public class Medium17电话号码的字母组合 {

    public static void main(String[] args) {
        Medium17电话号码的字母组合 medium17电话号码的字母组合 = new Medium17电话号码的字母组合();
        medium17电话号码的字母组合.letterCombinations("234").stream().forEach(System.out::println);
    }

    Map<Character, String> map;

    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        dfs(res, new String(), 0, digits);
        return res;
    }

    public void dfs(List<String> res, String tmp, int index, String dights) {
        if (tmp.length() == dights.length()) {
            res.add(tmp);
            return;
        }

        char key = dights.charAt(index);
        String s = map.get(key);
        for (int i = 0; i < s.length(); i++) {
            dfs(res, tmp + s.charAt(i), index + 1, dights);
        }
    }
}
