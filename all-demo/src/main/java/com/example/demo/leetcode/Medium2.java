package com.example.demo.leetcode;

/**
 * 两数相加
 *
 * @author zaochun.zjw
 * @date 2023/4/13
 */
public class Medium2 {

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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
}
