package com.example.demo.leetcode.types.stack.lc75.stack;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * <p>
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * @author zaochun.zjw
 * @date 2024/5/31
 */
public class Medium394字符串解码 {

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack();
        for (Character character : s.toCharArray()) {
            StringBuilder tmpRes = new StringBuilder();
            if (character == ']') {
                StringBuilder tmpBuilder = new StringBuilder();
                StringBuilder reverse = new StringBuilder();
                while (!stack.isEmpty()) {
                    if (stack.peek() != '[' && !(stack.peek() >= '0' && stack.peek() <= '9')) {
                        tmpBuilder.append(stack.pop());
                    } else if (stack.peek() == '[') {
                        stack.pop();
                        reverse = tmpBuilder.reverse();
                        break;
                    }
                }

                if (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    StringBuilder num = new StringBuilder();
                    while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
                        num.append(stack.pop());
                    }

                    int size = Integer.valueOf(num.reverse().toString());
                    for (int i = 0; i < size; i++) {
                        tmpRes.append(reverse);
                    }
                }else{
                    tmpRes.append(reverse);
                }

                for (int i = 0; i < tmpRes.length(); i++) {
                    stack.push(tmpRes.charAt(i));
                }
            } else {
                stack.push(character);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}


