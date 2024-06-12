package com.example.demo.leetcode.types.listnode.lc75;

import com.example.demo.leetcode.common.ListNode;

/**
 * @author zaochun.zjw
 * @date 2024/6/4
 */
public class Easy206反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }

        return pre;
    }
}
