package com.example.demo.leetcode.types.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author zaochun.zjw
 * @date 2024/3/20
 */
public class Easy118杨辉三角 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        res.add(objects);
        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }

            ArrayList<Integer> tmp = new ArrayList<>();
            for (int k = 0; k < numRows; k++) {
                if (dp[i][k] != 0) {
                    tmp.add(dp[i][k]);
                }
            }
            res.add(tmp);
        }

        return res;
    }
}
