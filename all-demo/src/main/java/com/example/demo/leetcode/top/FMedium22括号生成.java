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

    private List<String> res;

    /** 回溯法 （深度优先搜索） */
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        generateAll(new char[2 * n], n, n, 0);
        return res;
    }

    /**
     * @param nums
     * @param n     代表左括号的数量
     * @param m     代表右括号的数量
     * @param index 代表插入括号的位置
     */
    public void generateAll(char[] nums, int n, int m, int index) {
        if (n > m) {
            return;
        }

        if (n == 0 && m == 0) {
            res.add(String.valueOf(nums));
            return;
        }

        if (n > 0) {
            nums[index] = '(';
            generateAll(nums, n - 1, m, index + 1);
        }

        if (m > 0) {
            nums[index] = ')';
            generateAll(nums, n, m - 1, index + 1);
        }
    }
}
