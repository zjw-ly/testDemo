package com.example.demo.leetcode.types.stack.lc75.stack;

import java.util.Stack;

/**
 * 给你一个包含若干星号 * 的字符串 s 。
 * <p>
 * 在一步操作中，你可以：
 * 选中s中的一个星号。
 * 移除星号左侧最近的那个非星号字符，并移除该星号自身。
 * 返回移除所有星号之后的字符串。
 * <p>
 * 注意：
 * 生成的输入保证总是可以执行题面中描述的操作。
 * 可以证明结果字符串是唯一的。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "leet**cod*e"
 * 输出："lecoe"
 * 解释：从左到右执行移除操作：
 * - 距离第 1 个星号最近的字符是 "leet**cod*e" 中的 't' ，s 变为 "lee*cod*e" 。
 * - 距离第 2 个星号最近的字符是 "lee*cod*e" 中的 'e' ，s 变为 "lecod*e" 。
 * - 距离第 3 个星号最近的字符是 "lecod*e" 中的 'd' ，s 变为 "lecoe" 。
 * 不存在其他星号，返回 "lecoe" 。
 * <p>
 * 示例 2：
 * 输入：s = "erase*****"
 * 输出：""
 * 解释：整个字符串都会被移除，所以返回空字符串。
 *
 * @author zaochun.zjw
 * @date 2024/5/31
 */
public class Medium2309从字符串中移除星号 {

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }

    public  static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character cs : s.toCharArray()) {
            if (cs == '*' && !stack.isEmpty()){
                stack.pop();
            }else{
                stack.push(cs);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}
