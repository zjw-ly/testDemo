package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

/**
 *
 *
 * @author zaochun.zjw
 * @date 2024/3/8
 */
public class Medium2两数之和 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;
        while (l1 != null || l2 != null) {

            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = (x + y + carry) % 10;

            carry = (x + y + carry)/ 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return pre.next;
    }

    public static void main(String[] args) {

    }
}
