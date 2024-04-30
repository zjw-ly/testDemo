package com.example.demo.leetcode.types.hw;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * <p>
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * @author zaochun.zjw
 * @date 2024/4/28
 */
public class Easy240106字符串压缩 {

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }

    public static String compressString(String S) {
        if (S.length() == 0 || S.length() == 1) {
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int tmpCount = 1;
        Character character = S.charAt(0);
        stringBuilder.append(character);
        char[] array = S.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                stringBuilder.append(tmpCount);
                break;
            }

            if (S.charAt(i + 1) == S.charAt(i)) {
                tmpCount++;
            } else {
                stringBuilder.append(tmpCount);
                stringBuilder.append(S.charAt(i+1));
                tmpCount = 1;
            }
        }

        return stringBuilder.toString().length() >= S.length() ? S : stringBuilder.toString();
    }
}
