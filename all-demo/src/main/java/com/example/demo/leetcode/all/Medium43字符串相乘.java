package com.example.demo.leetcode.all;

/**
 * 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * @author zaochun.zjw
 * @date 2023/10/25
 */
public class Medium43字符串相乘 {

    public static void main(String[] args) {
        System.out.println(multiplyTest("123", "456"));
    }

    public static String multiplyTest(String num1, String num2) {
        String res = "0";

        for (int i = num1.length() - 1; i >= 0; i--) {
            int base = 0;
            int n1 = num1.charAt(i) - '0';

            StringBuilder dataly = new StringBuilder();
            for (int index = 0; index < num1.length() - i - 1; index++) {
                dataly.append("0");
            }
            for (int j = num2.length() - 1; j >= 0 || base > 0; j--) {
                int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
                int chengshu = n1 * n2 + base;
                dataly.append(chengshu % 10);
                base = chengshu / 10;
            }
            res = twoStrSum(res, dataly.reverse().toString());
        }

        return res;
    }

    public static String twoStrSum(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        while (index1 >= 0 || index2 >= 0 || carry != 0) {
            int n1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int n2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int sum = n1 + n2 + carry;
            str.append(sum % 10);
            carry = sum / 10;
            index1--;
            index2--;
        }

        return str.reverse().toString();
    }


    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }


}
