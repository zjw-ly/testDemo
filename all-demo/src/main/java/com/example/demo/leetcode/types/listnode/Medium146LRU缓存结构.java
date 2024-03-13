package com.example.demo.leetcode.types.listnode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author zaochun.zjw
 * @date 2024/3/10
 */
public class Medium146LRU缓存结构 {

    Queue<Integer> queue;

    Map<Integer, Integer> map;

    int maxLen;

    public Medium146LRU缓存结构(int capacity) {
        queue = new ArrayDeque<Integer>() {};
        map = new HashMap<>(capacity);
        maxLen = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        queue.remove(key);
        queue.offer(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.size() == maxLen) {
            if (!map.containsKey(key)) {
                Integer popKey = queue.poll();
                map.remove(popKey);
            }
        }

        if (map.containsKey(key)) {
            queue.remove(key);
        }

        queue.offer(key);
        map.put(key, value);
    }
}
