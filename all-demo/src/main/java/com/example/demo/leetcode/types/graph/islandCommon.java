package com.example.demo.leetcode.types.graph;

/**
 * 岛屿类通用解法 ： DFS
 *
 * @author zaochun.zjw
 * @date 2024/3/13
 */
public class islandCommon {

    public static void main(String[] args) {


    }

    public void common(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                }
            }
        }
    }

    public void dfs(char[][] grid, int m, int n) {
        // 是否越界
        if (!inLine(grid, n, n)) {
            return;
        }

        //
        if (grid[m][n] != '1') {
            //执行对应操作
            return;
        }

        grid[m][n] = '2';
        dfs(grid, m + 1, n);
        dfs(grid, m - 1, n);
        dfs(grid, m, n - 1);
        dfs(grid, m, n + 1);
    }

    public boolean inLine(char[][] grid, int m, int n) {
        return m >= 0 && m < grid.length && n >= 0 && n < grid[0].length;
    }
}
