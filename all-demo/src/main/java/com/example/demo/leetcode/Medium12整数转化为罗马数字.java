package com.example.demo.leetcode;

import java.util.Scanner;

/**
 * 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author zaochun.zjw
 * @date 2023/10/18
 */
public class Medium12整数转化为罗马数字 {

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int next = sc.nextInt();
            System.out.println(intToRoman(next));
        }
    }

    public static String intToRoman(int num) {
        int hun = num / 1000;
        int hunYu = num % 1000;

        StringBuilder stringBuilder = new StringBuilder();
        if (hun > 0) {
            while (hun > 0) {
                stringBuilder.append("M");
                hun--;
            }
        }

        if (hunYu >= 900) {
            stringBuilder.append("CM");
            hunYu = hunYu - 900;
        }

        if (hunYu >= 500) {
            stringBuilder.append("D");
            hunYu -= 500;
        }

        if (hunYu >= 400) {
            stringBuilder.append("CD");
            hunYu -= 400;
        }

        int bai = hunYu / 100;
        int baiYu = hunYu % 100;
        while (bai > 0) {
            stringBuilder.append("C");
            bai--;
        }

        if (baiYu >= 90) {
            stringBuilder.append("XC");
            baiYu -= 90;
        }

        if (baiYu >= 50) {
            stringBuilder.append("L");
            baiYu -= 50;
        }

        if (baiYu >= 40) {
            stringBuilder.append("XL");
            baiYu -= 40;
        }

        int shi = baiYu / 10;
        int shiYu = baiYu % 10;
        while (shi > 0) {
            stringBuilder.append("X");
            shi--;
        }

        if (shiYu >= 9) {
            stringBuilder.append("IX");
            shiYu -= 9;
        }

        if (shiYu >= 5) {
            stringBuilder.append("V");
            shiYu -= 5;
        }


        if (shiYu >= 4) {
            stringBuilder.append("IV");
            shiYu -= 4;
        }

        while (shiYu > 0) {
            stringBuilder.append("I");
            shiYu--;
        }

        return stringBuilder.toString();
    }
}
