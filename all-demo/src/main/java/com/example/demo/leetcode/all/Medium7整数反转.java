package com.example.demo.leetcode.all;

import java.util.Scanner;

/**
 * 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 * @author zaochun.zjw
 * @date 2023/10/18
 */
public class Medium7整数反转 {

    public static void main(String[] args) {
        for (int i = 0; i < 999; i++) {
            Scanner scanner = new Scanner(System.in);
            int nextInt = scanner.nextInt();
            if (i == 999) {
                scanner.close();
            } else {
                System.out.println(reverse(nextInt));
            }
        }
    }


    public static int reverse(int x) {
        String s = String.valueOf(x);
        if (x == 0) {
            return x;
        }

        int index = 0;
        if (x < 0) {
            index = 1;
        }

        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        int firstNoZero = index;
        for (int end = chars.length - 1; end >= index; end--) {
            if (chars[end] != '0') {
                firstNoZero = end;
                break;
            }
        }

        for (int i = firstNoZero; i >= index; i--) {
            str.append(chars[i]);
        }

        try{
            if (x > 0) {
                return Integer.parseInt(str.toString());
            } else {
                return Integer.parseInt("-" + str.toString());
            }
        }catch (NumberFormatException e){
            return 0;
        }

    }


}
