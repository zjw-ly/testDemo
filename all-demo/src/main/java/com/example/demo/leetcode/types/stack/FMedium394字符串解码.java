package com.example.demo.leetcode.types.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
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
 * @date 2024/3/18
 */
public class FMedium394字符串解码 {

    public static void main(String[] args) {
        FMedium394字符串解码 tmp = new FMedium394字符串解码();
        //[z]2[2[y]pq4[2[jk]e1[f]]]ef
        //yypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
        System.out.println(tmp.decodeString("3[a2[c]]"));
    }

    //构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
    //当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
    //当 c 为字母时，在 res 尾部添加 c；
    //当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 000：
    //记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
    //记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
    //进入到新 [ 后，res 和 multi 重新记录。
    //当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
    //last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
    //cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
    //返回字符串 res。
    //
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int numTmp = 0;
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                numStack.addLast(numTmp);
                strStack.addLast(res.toString());
                numTmp = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int num = numStack.removeLast();
                for (int i = 0; i < num; i++) tmp.append(res);
                res = new StringBuilder(strStack.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') numTmp = numTmp * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
}
