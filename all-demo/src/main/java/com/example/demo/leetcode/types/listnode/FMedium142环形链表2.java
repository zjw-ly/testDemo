package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

/**
 * 环形链表2
 *
 * @author zaochun.zjw
 * @date 2024/3/7
 */
public class FMedium142环形链表2 {

    public static ListNode detectCycle(ListNode head) {
        ListNode a = head.next;
        ListNode b = head.next.next;
        if (head == null || a == null || b == null) {
            return null;
        }

        while (a != null && b != null) {
            if (a == b) {
                break;
            }
            a = a.next;
            if (b.next == null) {
                return null;
            }
            b = b.next.next;
        }
        ListNode x = head;
        while(x != a){
            x = x.next;
            a = x.next;
        }

        return  a;
    }

    public static void main(String[] args) {

    }
}
