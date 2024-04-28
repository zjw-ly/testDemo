package com.example.demo.leetcode.types.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author zaochun.zjw
 * @date 2024/4/9
 */
public class Medium54螺旋矩阵 {

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3,4}, { 5, 6,7,8}, {9,10,11,12}};
        spiralOrder(ints).stream().forEach(System.out::println);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int up = 0, down = matrix.length, left = 0, right = matrix[0].length;
        while (true) {
            for (int i = left; i < right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            if (up >= down) {
                break;
            }

            for (int tmpHang = up; tmpHang < down; tmpHang++) {
                res.add(matrix[tmpHang][right-1]);
            }
            right--;
            if (right <= left) {
                break;
            }

            for (int tmpLie = right-1; tmpLie >= left; tmpLie--) {
                res.add(matrix[down-1][tmpLie]);
            }
            down--;
            if (down <= up) {
                break;
            }

            for (int tmpHang = down-1; tmpHang >= up; tmpHang--) {
                res.add(matrix[tmpHang][left]);
            }
            left++;
            if (left >= right) {
                break;
            }
        }

        return res;
    }
}
