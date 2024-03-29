package com.example.demo.leetcode.top;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 */
public class FMedium22括号生成 {

    public static void main(String[] args) {
        FMedium22括号生成 FMedium22括号生成 = new FMedium22括号生成();
        System.out.println(FMedium22括号生成.generateParenthesis(3));
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
