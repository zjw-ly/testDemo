package com.example.demo.leetcode.test;

import java.util.*;

/**
 * @author zaochun.zjw
 * @date 2024/3/5
 */
public class Test {

    public static void main(String[] args) {
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> tmp = map.getOrDefault(prerequisites[i][1], new ArrayList<>());
            tmp.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], tmp);
        }

        int[] nums = new int[numCourses];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (Integer value : entry.getValue()) {
                nums[value] = nums[value]++;
            }
        }

        int inSize = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (nums[i] == 0) {
                inSize++;
                queue.push(nums[i]);
            }
        }

        if (inSize == numCourses) {
            return true;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                List<Integer> list = map.get(poll);
                for (Integer x : list) {
                    nums[x] = nums[x]--;
                    if (nums[x] == 0) {
                        queue.push(x);
                        inSize++;
                    }
                }

                if (inSize == numCourses) {
                    return true;
                }
            }
        }

        return false;
    }
}
