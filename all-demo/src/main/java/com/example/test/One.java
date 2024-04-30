package com.example.test;

import java.util.Scanner;

/**
 * @author zaochun.zjw
 * @date 2024/4/29
 */
public class One {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        String[] strs = str.split(" ");
        int[] tree = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            tree[i] = Integer.parseInt(strs[i]);
        }

        dfs(tree, 0, tree);
        System.out.println(maxLength);
    }

    public static int maxLength = Integer.MIN_VALUE;

    public static void dfs(int[] tree, int index, int[] tmp) {
        if(tree.length == 1){
            maxLength = 0;
        }

        if (index > tree.length || tree[index] == -1) {
            return;
        }

        if (2 * index + 1 < tree.length && tmp[2 * index + 1] != -1) {
            tmp[2 * index + 1] = tree[index] + tmp[2 * index + 1];
            maxLength = Math.max(tmp[2 * index + 1], maxLength);
            dfs(tree, 2 * index + 1, tmp);
        }

        if (2 * index + 2 < tree.length && tmp[2 * index + 2] != -1) {
            tmp[2 * index + 2] = tree[index] + tmp[2 * index + 2];
            maxLength = Math.max(tmp[2 * index + 2], maxLength);
            dfs(tree, 2 * index + 2, tmp);
        }
    }
}
