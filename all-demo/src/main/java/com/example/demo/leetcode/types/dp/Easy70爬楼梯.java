package com.example.demo.leetcode.types.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * @author zaochun.zjw
 * @date 2024/3/20
 */
public class Easy70爬楼梯 {

    public static void main(String[] args) {
        Easy70爬楼梯 tmp = new Easy70爬楼梯();
        System.out.println(tmp.climbStairsDp(5));
    }

    int res = 0;

    public int climbStairsDp(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (j < i) {
                    dp[i][j] = 0;
                }
                if (i == j) {
                    dp[i][j] = 1;
                }
                if (j > i) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j - 2];
                }
            }
        }

        int res = 0;
        for(int i = 0;i<n;i++){
            res += dp[i][n-1];
        }
        return res;
    }

    public int climbStairsDfs(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        dfs(n);
        return res;
    }

    public void dfs(int n) {
        if (n == 0) {
            res++;
        }

        if (n - 1 >= 0) {
            dfs(n - 1);
        }

        if (n - 2 >= 0) {
            dfs(n - 2);
        }
    }


}
