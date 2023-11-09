package com.example.demo.leetcode;

import com.example.demo.leetcode.common.ListNode;

/**
 * 合并k个生序链表
 *
 * @author zaochun.zjw
 * @date 2023/11/2
 */
public class Hard23合并k个生序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = combine(ans, lists[i]);
        }

        return ans;
    }

    public ListNode combine(ListNode a, ListNode b) {
        if(a == null && b==null){
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode tmp = head.next;
        while (a != null || b != null) {
            if (a == null) {
                tmp.next = b;
                break;
            }

            if (b == null) {
                tmp.next = a;
                break;
            }

            if (a.val > b.val) {
                tmp.next = b;
                b = b.next;
            } else {
                tmp.next = a;
                a = a.next;
            }

            tmp = tmp.next;
        }

        return head.next;
    }
}
