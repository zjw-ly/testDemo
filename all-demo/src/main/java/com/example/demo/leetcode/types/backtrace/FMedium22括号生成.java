package com.example.demo.leetcode.types.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * <p>
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 *
 * @author zaochun.zjw
 * @date 2024/3/15
 */
public class FMedium22括号生成 {

    public static void main(String[] args) {
        FMedium22括号生成 tmp = new FMedium22括号生成();
        tmp.generateParenthesis(3).stream().forEach(System.out::println);
    }

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        DFS(n, n, new String());
        return res;
    }

    public void DFS(int left, int right, String tmp) {
        if (left == 0 && right == 0) {
            res.add(tmp);
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            DFS(left - 1, right, tmp + "(");
        }
        if (right > 0) {
            DFS(left, right - 1, tmp + ")");
        }
    }
}
