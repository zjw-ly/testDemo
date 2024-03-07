package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

import java.util.List;

/**
 * 反转链表
 *
 * @author zaochun.zjw
 * @date 2024/3/7
 */
public class Easy206反转链表 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
