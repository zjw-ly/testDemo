package com.example.demo.leetcode.types.twosearch;

/**
 * 搜索二维矩阵
 *
 * @author zaochun.zjw
 * @date 2024/3/18
 */
public class Medium74搜索二维矩阵 {

    public static void main(String[] args) {
        Medium74搜索二维矩阵 tmp = new Medium74搜索二维矩阵();
        System.out.println(tmp.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 36, 60}}, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int hang = matrix.length;
        int lie = matrix[0].length;

        int right = hang * lie - 1;
        int left = 0;
        while (left <= right) {
            int leftHang = left / lie;
            int leftLie = left % lie;
            int leftVale = matrix[leftHang][leftLie];
            int rightHang = right / lie;
            int rightLie = right % lie;
            int rightValue = matrix[rightHang][rightLie];

            if (target < leftVale || target > rightValue) {
                return false;
            }

            int mid = (left + right) / 2;
            int midHang = mid / lie;
            int midLie = mid % lie;
            int midValue = matrix[midHang][midLie];

            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }

        return false;
    }
}
