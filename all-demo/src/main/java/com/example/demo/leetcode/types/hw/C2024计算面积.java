package com.example.demo.leetcode.types.hw;

import java.util.Scanner;

/**
 * 计算面积
 *
 * @author zaochun.zjw
 * @date 2024/4/28
 */
public class C2024计算面积 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hang = sc.nextInt();
        int length = sc.nextInt();
        int[][] num = new int[hang][2];
        for (int i = 0; i < hang; i++) {
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
        }

        System.out.println(getArea(num,length));
    }


    public static int getArea(int[][] num, int lie) {
        int length = 0;
        int res = 0;
        int i = 0;
        for (; i < num.length; i++) {
            length += num[i][1];
            res += Math.abs(length);
        }
        for (; i < lie-1; i++) {
            res += Math.abs(length);
        }

        return res;
    }
}
