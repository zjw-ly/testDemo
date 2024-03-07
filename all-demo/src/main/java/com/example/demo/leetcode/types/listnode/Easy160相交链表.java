package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

/**
 * @author zaochun.zjw
 * @date 2024/3/7
 */
public class Easy160相交链表 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a1 = headA, b1 = headB;
        while(a1 != b1){
            a1 = (a1==null?headB:a1.next);
            b1 = (b1==null?headA:b1.next);
        }

        return a1;
    }

    public static void main(String[] args) {

    }
}
