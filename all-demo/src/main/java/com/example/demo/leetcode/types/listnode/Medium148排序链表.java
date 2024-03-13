package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 排序链表
 *
 * @author zaochun.zjw
 * @date 2024/3/9
 */
public class Medium148排序链表 {


    public ListNode sortList(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        while (cur != null) {
            queue.offer(cur.val);
            cur = cur.next;
        }
        ListNode tmp = pre;
        while (!queue.isEmpty()) {
            tmp.next = new ListNode(queue.poll());
            tmp = tmp.next;
        }

        return pre.next;
    }

    public static void main(String[] args) {

    }
}
