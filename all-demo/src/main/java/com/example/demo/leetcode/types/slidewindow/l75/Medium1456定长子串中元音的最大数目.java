package com.example.demo.leetcode.types.slidewindow.l75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * <p>
 * 示例 2：
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * <p>
 * 示例 3：
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * <p>
 * 示例 4：
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * <p>
 * 示例 5：
 * 输入：s = "tryhard", k = 4
 * 输出：1
 *
 * @author zaochun.zjw
 * @date 2024/5/29
 */
public class Medium1456定长子串中元音的最大数目 {

    public int maxVowels(String s, int k) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = k - 1;
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (list.contains(chars[i])) {
                res++;
            }
        }

        if (res == k) {
            return res;
        }

        int tmpRes = res;
        while (right < s.length() - 1) {
            if (list.contains(chars[left])) {
                tmpRes--;
            }
            left++;
            right++;
            if (list.contains(chars[right])) {
                tmpRes++;
            }
            res = Math.max(res,tmpRes);
        }

        return res;
    }
}
