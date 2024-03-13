package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zaochun.zjw
 * @date 2024/3/9
 */
public class Hard23合并k个生序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            ListNode tmp = lists[i];
            while (tmp != null) {
                priorityQueue.offer(tmp.val);
                tmp = tmp.next;
            }
        }

        ListNode pre = new ListNode();
        ListNode tmp = pre;
        while (!priorityQueue.isEmpty()) {
            tmp.next = new ListNode(priorityQueue.poll());
            tmp = tmp.next;
        }

        return pre.next;
    }
}
