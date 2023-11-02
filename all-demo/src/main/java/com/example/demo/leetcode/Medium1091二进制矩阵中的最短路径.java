package com.example.demo.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二进制矩阵中的最短路径
 * <p>
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * 示例 1：
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 *
 * @author zaochun.zjw
 * @date 2023/10/25
 */
public class Medium1091二进制矩阵中的最短路径 {


    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrixTest(nums));
    }

    public static int shortestPathBinaryMatrixTest(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[] index = new boolean[m * n];
        index[0] = true;

        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(0);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int queueNum = 0; queueNum < size; queueNum++) {
                Integer poll = queue.poll();
                if (poll == m * n - 1) {
                    return ans;
                }
                int prox = poll / n;
                int proy = poll % n;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int x = prox + i;
                        int y = proy + j;
                        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 1) {
                            continue;
                        }
                        if (index[x * n + y]) continue;
                        index[x * n + y] = true;
                        queue.add(x * n + y);
                    }
                }
            }
        }

        return -1;
    }


    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[] vis = new boolean[m * n];
        vis[0] = true;

        Deque<Integer> q = new LinkedList<>();
        q.addLast(0);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int t = q.pollFirst();
                if (t == m * n - 1) return ans + 1;
                int x = t / n;
                int y = t % n;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int xx = x + i;
                        int yy = y + j;
                        if (xx >= m || yy >= n || xx < 0 || yy < 0 || grid[xx][yy] == 1) continue;
                        if (vis[xx * n + yy]) continue;
                        q.addLast(xx * n + yy);
                        vis[xx * n + yy] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}
