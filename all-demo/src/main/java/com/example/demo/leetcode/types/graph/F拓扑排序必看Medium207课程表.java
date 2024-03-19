package com.example.demo.leetcode.types.graph;

import java.util.*;

/**
 * 1. 解决有向无环图 需要的几个定义：邻接表(构建拓扑排列几乎必用)、入度(根据邻接表判断)、出度(构建邻接表表示)等
 * 2. 邻接表的定义：得出全部元素o的所有指向，代码上用hashMap -> key，List<被指向集合>的方式表达出来 key代表元素本身，list代表出度
 * 3. 设计流程：构建一个数组 表示其关联的入度数量，将入度为0的塞入队列中 进行BFS；通过邻接表可以将其出度取出 并不断塞入队列中循环。
 * <p>
 * <p>
 * 课程表
 *
 * @author zaochun.zjw
 * @date 2024/3/14
 */
public class F拓扑排序必看Medium207课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> temp = map.getOrDefault(prerequisites[i][1], new ArrayList<>());
            temp.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], temp);
        }
        // 求所有元素的入度
        int[] nodes = new int[numCourses];
        for (Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
            for (int num : m.getValue()) {
                nodes[num]++;
            }
        }

        // 首先将入度为0的元素依次入栈
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 0) {
                deque.push(i);
            }
        }
        if (deque.size() == 0) {
            return false;
        }

        // 将入度为0的元素依次入栈
        int count = deque.size();
        while (!deque.isEmpty()) {
            if (count == numCourses) {
                return true;
            }
            int node = deque.pop();
            if (map.containsKey(node)) {
                for (int n : map.get(node)) {
                    nodes[n]--;
                    if (nodes[n] == 0) {
                        deque.push(n);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}
