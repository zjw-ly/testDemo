package com.example.demo.leetcode;

/**
 * 外观数列
 * <p>
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要描述一个数字字符串，首先要将字符串分割为最小数量的组，每个组都由连续的最多相同字符组成。然后对于每个组，先描述字符的数量，然后描述字符，
 * 形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 * <p>
 * 例如，数字字符串 "3322251" 的描述如下图：
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出："1"
 * 解释：这是一个基本样例。
 * 示例 2：
 * <p>
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 * 提示：
 * <p>
 * 1 <= n <= 30
 *
 * @author zaochun.zjw
 * @date 2023/10/23
 */
public class Medium38外观数列 {

    public static void main(String[] args) {
        //23321511
        Medium38外观数列 medium38外观数列 = new Medium38外观数列();
        System.out.println(medium38外观数列.countAndSay(7));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return String.valueOf(1);
        } else if (n == 2) {
            return String.valueOf(11);
        } else if (n == 3) {
            return String.valueOf(21);
        } else if (n == 4) {
            return String.valueOf(1211);
        } else if (n == 5) {
            return String.valueOf(111221);
        }

        int dsx = n - 5;
        return getDesc("111221",dsx);
    }

    public String getDesc(String n,int times) {
        if(times == 0){
            return n;
        }

        StringBuilder res = new StringBuilder();
        int left = 0;
        String val = n;
        while (left < val.length()) {
            char i = val.charAt(left);
            int index = 0;
            while (left < val.length() && i == val.charAt(left)) {
                index++;
                left++;
            }
            res.append(index);
            res.append(i);
        }

        return getDesc(res.toString(),--times);
    }
}







