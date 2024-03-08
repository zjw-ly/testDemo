package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

/**
 * 合并两个有序链表
 *
 * @author zaochun.zjw
 * @date 2024/3/8
 */
public class Easy21合并两个有序链表 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (list1 != null || list2 != null) {
            if (list1 == null){
                tmp.next = list2;
                break;
            }
            if (list2 == null) {
                tmp.next = list1;
                break;
            }

            if (list1.val > list2.val) {
                tmp.next = list2;
                list2 = list2.next;
            } else {
                tmp.next = list1;
                list1 = list1.next;
            }

            tmp = tmp.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }
}
