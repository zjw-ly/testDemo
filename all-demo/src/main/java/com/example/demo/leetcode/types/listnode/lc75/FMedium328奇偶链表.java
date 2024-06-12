package com.example.demo.leetcode.types.listnode.lc75;

import com.example.demo.leetcode.common.ListNode;

/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 *
 * @author zaochun.zjw
 * @date 2024/6/3
 */
public class FMedium328奇偶链表 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(6);
        a.next.next.next.next.next.next = new ListNode(7);
        oddEvenListTest(a);

        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }

    public static ListNode oddEvenListTest(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode evenhead = head.next;
        ListNode odd = head;
        ListNode even = evenhead;
        while (even != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
