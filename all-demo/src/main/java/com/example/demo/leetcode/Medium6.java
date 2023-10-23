package com.example.demo.leetcode;

/**
 * N字形变换
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * @author zaochun.zjw
 * @date 2023/10/18
 */
public class Medium6 {

    public static void main(String[] args) {

    }

    public static String convert1(String s, int numRows) { //只有一行时
        StringBuffer res = new StringBuffer();
        int add = numRows > 1 ? numRows * 2 - 2 : 1;
        int len = s.length();
        for (int i = 1; i <= numRows; i++) {
            int j = i;
            int det = i * 2 - 2;
            boolean front = true;
            while (j <= len) {
                res.append(s.charAt(j - 1));
                if (i == 1 || i == numRows) {
                    j += add;
                } else {
                    if (front) {
                        j += (add - det);
                        front = false;
                    } else {
                        j += det;
                        front = true;
                    }
                }
            }
        }
        return res.toString();

    }
}
