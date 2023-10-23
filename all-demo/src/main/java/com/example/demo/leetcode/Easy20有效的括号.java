package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 示例 1：
 * <p>
 * 输入：s = '()'
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = '()[]{}'
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = '(]'
 * 输出：false
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 */
public class Easy20有效的括号 {

    public static void main(String[] args) {
        System.out.println(isValid(")"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')' , '(');
        map.put(']' , '[');
        map.put('}' , '{');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
