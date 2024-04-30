package com.example.demo.leetcode.types.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 给定一段 “密文”字符串 s ，其中字符都是经过 “密码本” 映射的，现需要将“密文”解密并且输出。
 *
 * 映射的规则：
 * ( a−i ) 分别用(1−9 )表示；
 * (j−z ) 分别用(10∗−26∗ )表示。
 * 约束：映射始终唯一。
 *
 * 输入描述
 * “密文”字符串
 *
 * 输出描述
 * 明文字符串
 *
 * 示例1
 * 输入：
 * 20*19*20*
 *
 * 输出：
 * tst
 *
 * 说明：
 * 翻译后的文本长度在 100 以内。
 *
 *
 * 作者：code5bug
 * 链接：https://www.nowcoder.com/discuss/607521682718208000?sourceSSR=search
 * 来源：牛客网
 *
 * @author zaochun.zjw
 * @date 2024/4/28
 */
public class C2024密码解码 {

    public static void main(String[] args) {
        System.out.println('a' - 48);

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(parseStr(str));
    }

    public static String parseStr(String str){
        Map<String,String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","a");
        map.put("3","a");
        map.put("1","a");
        map.put("1","a");
        map.put("1","a");
        map.put("1","a");
        map.put("1","a");
        return null;
    }
}
