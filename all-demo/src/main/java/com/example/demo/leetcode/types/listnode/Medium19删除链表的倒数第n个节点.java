package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

/**
 * @author zaochun.zjw
 * @date 2024/3/8
 */
public class Medium19删除链表的倒数第n个节点 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode listNode = removeNthFromEnd(l1, 2);
        System.out.println(listNode);
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode tmp = head;
        int index = 0;
        while (tmp != null) {
            index++;
            tmp = tmp.next;
        }

        int i = 0;
        while (head != null) {
            i++;
            if (index - i == n) {
                if(head.next!=null){
                    head.next = head.next.next;
                }
            }

            head = head.next;
        }

        return pre.next;
    }
}
