package com.example.demo.leetcode.types.matrix;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * @author zaochun.zjw
 * @date 2024/4/9
 */
public class Medium73矩阵置零 {

    public void setZeroes(int[][] matrix) {
        int hang = matrix.length;
        int lie = matrix[0].length;
        boolean[][] hasZero = new boolean[hang][lie];

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                if (matrix[i][j] == 0) {
                    hasZero[i][j] = true;
                }
            }
        }

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                if (hasZero[i][j]) {
                    for(int k = 0;k<lie;k++){
                        matrix[i][k] = 0;
                    }

                    for(int k = 0;k<hang;k++){
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}
