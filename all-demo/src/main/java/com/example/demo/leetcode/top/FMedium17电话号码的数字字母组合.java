package com.example.demo.leetcode.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的数字字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 *
 * 递归
 */
public class FMedium17电话号码的数字字母组合 {

    public static void main(String[] args) {
        FMedium17电话号码的数字字母组合 FMedium17电话号码的数字字母组合 = new FMedium17电话号码的数字字母组合();
        System.out.println(FMedium17电话号码的数字字母组合.letterCombinations("234"));
    }

    private ArrayList<String> res;

    private Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        map.put('2' , "abc");
        map.put('3' , "def");
        map.put('4' , "ghi");
        map.put('5' , "jkl");
        map.put('6' , "mno");
        map.put('7' , "pqrs");
        map.put('8' , "tuv");
        map.put('9' , "wxyz");

        if (digits.equals("")) return res;
        findTel(digits, 0, "");
        return res;
    }

    private void findTel(String dight, int index, String s) {
        if (s.length() == dight.length()) {
            res.add(s);
            return;
        }

        String s1 = map.get(dight.charAt(index));
        for (int i = 0; i < s1.length(); i++) {
            findTel(dight, index + 1, s + s1.charAt(i));
        }
        return;
    }
}
