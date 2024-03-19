package com.example.demo.leetcode.types.stack;

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
 *
 * @author zaochun.zjw
 * @date 2024/3/18
 */
public class Easy20有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (Character cs : s.toCharArray()) {
            if (map.containsKey(cs)) {
                stack.push(cs);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop();
                if (!map.get(pop).equals(cs)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
