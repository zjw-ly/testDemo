package com.example.demo.leetcode.types.heap;

import java.util.*;

/**
 * 高频元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author zaochun.zjw
 * @date 2024/3/19
 */
public class Medium347前k个高频元素 {

    public static void main(String[] args) {
        Arrays.stream(topKFrequent(new int[]{1}, 1)).forEach(System.out::println);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = map.getOrDefault(nums[i], 0);
            map.put(nums[i], orDefault + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            res[i] = poll[0];
        }

        return res;
    }
}
