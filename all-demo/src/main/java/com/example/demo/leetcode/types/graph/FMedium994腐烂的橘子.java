package com.example.demo.leetcode.types.graph;

import java.util.ArrayDeque;

/**
 * 腐烂的橘子 - 这道题的根本思路在于 所有腐烂橘子都必须"同时"感染身边的好橘子、因此BFS的队列思想可以将每一层关联进一个循环操作
 *
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * @author zaochun.zjw
 * @date 2024/3/14
 */
public class FMedium994腐烂的橘子 {

    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        int count = 0;
        int min = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    arrayDeque.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        while (!arrayDeque.isEmpty()) {
            int size = arrayDeque.size();
            min++;
            for (int i = 0; i < size; i++) {
                int[] poll = arrayDeque.poll();
                int hang = poll[0];
                int lie = poll[1];
                if (hang - 1 >= 0 && grid[hang - 1][lie] == 1) {
                    grid[hang - 1][lie] = 2;
                    count--;
                    arrayDeque.offer(new int[]{hang - 1, lie});
                }

                if (hang + 1 < m && grid[hang + 1][lie] == 1) {
                    grid[hang + 1][lie] = 2;
                    count--;
                    arrayDeque.offer(new int[]{hang + 1, lie});
                }

                if (lie - 1 >= 0 && grid[hang][lie - 1] == 1) {
                    grid[hang][lie - 1] = 2;
                    count--;
                    arrayDeque.offer(new int[]{hang, lie - 1});
                }

                if (lie + 1 < n && grid[hang][lie + 1] == 1) {
                    grid[hang][lie + 1] = 2;
                    count--;
                    arrayDeque.offer(new int[]{hang, lie + 1});
                }
            }
        }

        return count == 0 ? min -1  : -1;
    }
}
