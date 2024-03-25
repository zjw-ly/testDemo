package com.example.demo.leetcode.types.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * @author zaochun.zjw
 * @date 2024/3/19
 */
public class Medium739每日温度 {

    public static void main(String[] args) {
        Arrays.stream(dailyTemperatures(new int[]{30,40,50,60})).forEach(System.out::println);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < temperatures.length; i++) {
            while (!queue.isEmpty()) {
                int[] peek = queue.peek();
                if (peek[1] < temperatures[i]) {
                    ans[peek[0]] = i - peek[0];
                    queue.poll();
                    continue;
                }

                break;
            }

            queue.offer(new int[]{i, temperatures[i]});
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            ans[poll[0]] = 0;
        }

        return ans;
    }
}
