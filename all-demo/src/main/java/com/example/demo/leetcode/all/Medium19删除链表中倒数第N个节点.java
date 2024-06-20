package com.example.demo.leetcode.all;

/**
 * 删除链表的倒数第N个节点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 */
public class Medium19删除链表中倒数第N个节点 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(removeNthFromEnd(l1,2).toString());
    }

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int maxLength = 0;
        ListNode a = head;
        while (a != null) {
            a = a.next;
            maxLength++;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode cur = pre;
        int index = 0;
        int num = maxLength - n;
        while (cur != null) {
            if (num == index) {
                ListNode next = cur.next;
                if(next != null){
                    cur.next = next.next;
                }

                break;
            }

            index ++;
            cur = cur.next;
        }

        return cur.next;
    }
}
