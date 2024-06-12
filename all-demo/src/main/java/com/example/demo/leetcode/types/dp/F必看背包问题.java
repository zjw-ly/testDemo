package com.example.demo.leetcode.types.dp;

/**
 * @author zaochun.zjw
 * @date 2024/3/20
 */
public class F必看背包问题 {

    // todo 01背包问题
    //问题形式化：
    //注：每个商品只能取一次
    //输入：物品的数量为( n )，每个物品的重量为( w_i )，价值为( v_i )，背包的最大容量为( W )。
    //输出：在不超过背包容量的前提下，最大的价值总和。

    //todo 解题思路
    //背包容量相当于一个横向矩阵、每个物品的价值相当于纵向数组，双层循环处理每层最优选择
    //外层循环，先轮询全部物品，将物品依次塞入可满足的背包容量中 并寻找局部最优
    //内层循环中，先拿到当前物品的价值、 通过当前物品最多能从什么容量中放置进行判断 -》 比较现有价值 以及 判断后的价值

    public static int knapsack(int[] weights, int[] values, int W) {
        // 物品重量
        int n = weights.length;

        // dp数组，初始化为0
        int[] dp = new int[W + 1];

        // 遍历每一个物品
        for (int i = 0; i < n; i++) {
            // 从大到小遍历所有容量，确保每个物品只被计算一次
            for (int j = W; j >= weights[i]; j--) {
                // 状态转移方程
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        // 返回背包容量W下的最大价值
        return dp[W];
    }


    // todo 完全背包问题
    //问题形式化：
    //注：每个商品可以取无数次
    //输入：物品的数量为( n )，每个物品的重量为( w_i )，价值为( v_i )，背包的最大容量为( W )。
    //输出：在不超过背包容量的前提下，最大的价值总和。

    //todo 解题思路
    //背包容量相当于一个横向矩阵、每个物品的价值相当于纵向数组，双层循环处理每层最优选择
    //外层循环，先轮询全部物品，将物品依次塞入可满足的背包容量中 并寻找局部最优
    //内层循环中，先将

    public static int allKnapsack(int[] weights, int[] values, int W) {
        // 物品重量
        int n = weights.length;

        // dp数组，初始化为0
        int[] dp = new int[W + 1];

        // 遍历每一个物品
        for (int i = 0; i < n; i++) {
            // 从小到大遍历数据
            for (int j = weights[i]; j <= W; j++) {
                // 状态转移方程
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        // 返回背包容量W下的最大价值
        return dp[W];
    }


    public static void main(String[] args) {
        int W = 10; // 背包容量
        int[] weights = {1, 3, 4, 6}; // 物品重量
        int[] values = {2, 4, 5, 8}; // 物品价值
        int n = weights.length; // 物品数量

        System.out.println("01背包最大价值为: " + knapsack(weights, values, W));
        System.out.println("完全背包最大价值为: " + allKnapsack(weights, values, W));

    }
}
