package com.example.demo.leetcode.types.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zaochun.zjw
 * @date 2024/3/14
 */
public class Medium17电话号码的字母组合 {

    public static void main(String[] args) {
        Medium17电话号码的字母组合 medium17电话号码的字母组合 = new Medium17电话号码的字母组合();
        medium17电话号码的字母组合.letterCombinations("23").stream().forEach(System.out::println);
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
        dfs(res,new String(),0,digits);
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
