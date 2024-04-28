package com.example.demo.leetcode.types.dpmore;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 *
 * @author zaochun.zjw
 * @date 2024/4/12
 */
public class TMedium62不同路径 {

    public static void main(String[] args) {
        TMedium62不同路径 tmp = new TMedium62不同路径();
        System.out.println(tmp.uniquePaths(23, 12));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                }

                if (j == 0) {
                    dp[i][j] = 1;
                }

                if (i != 0 && j != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    int res = 0;

    public int uniquePathsTest(int m, int n) {
        dfs(0, 0, m, n);
        return res;
    }

    public void dfs(int tmpHang, int tmpLie, int m, int n) {
        if (!verifyInline(tmpHang, tmpLie, m, n)) {
            return;
        }

        if (tmpHang == m - 1 && tmpLie == n - 1) {
            res++;
        }

        dfs(tmpHang + 1, tmpLie, m, n);
        dfs(tmpHang, tmpLie + 1, m, n);
    }

    public boolean verifyInline(int tmpHang, int tmpLie, int m, int n) {
        return tmpHang < m && tmpLie < n;
    }
}
