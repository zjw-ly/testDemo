package com.example.demo.leetcode.types.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 *
 * @author zaochun.zjw
 * @date 2024/5/31
 */
public class Medium2352相当行列对 {

    public static void main(String[] args) {
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        int countSize = 0;
        if (grid.length != grid[0].length) {
            return countSize;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> res2 = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            List<Integer> tmp2 = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                tmp.add(grid[i][j]);
                tmp2.add(grid[j][i]);
            }
            res.add(tmp);
            res2.add(tmp2);
        }

        for (List<Integer> tmpList : res) {
            for (List<Integer> integers : res2) {
                int k = 0;
                for (; k < tmpList.size(); k++) {
                    if (!Objects.equals(integers.get(k), tmpList.get(k))) {
                        break;
                    }
                }

                if (k == tmpList.size()) {
                    countSize++;
                }
            }
        }

        return countSize;
    }
}
