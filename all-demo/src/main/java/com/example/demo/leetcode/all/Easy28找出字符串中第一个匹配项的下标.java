package com.example.demo.leetcode.all;

/**
 * 找出字符串中第一个匹配项的下标
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 * @author zaochun.zjw
 * @date 2023/10/20
 */
public class Easy28找出字符串中第一个匹配项的下标 {

    public static void main(String[] args) {
        System.out.println(strStr("aaa", "aaaa"));
    }

    public static int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            int index = i;
            int j = 0;
            for (; j < needle.length(); j++) {
                if (index < haystack.length() && haystack.charAt(index) == needle.charAt(j) ) {
                    index++;
                }else{
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
