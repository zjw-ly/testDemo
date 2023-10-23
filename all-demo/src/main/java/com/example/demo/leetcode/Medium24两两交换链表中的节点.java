package com.example.demo.leetcode;

import com.example.demo.leetcode.common.ListNode;

/**
 * 两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 */
public class Medium24两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(swapPairs(l1).toString());
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode preNode = pre;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode before = new ListNode(cur.next.val);
            ListNode next = new ListNode(cur.val);
            before.next = next;

            preNode.next = before;
            preNode = preNode.next.next;

            cur = cur.next.next;
        }

        if (cur != null) {
            preNode.next = cur;
        }

        return pre.next;
    }
}
