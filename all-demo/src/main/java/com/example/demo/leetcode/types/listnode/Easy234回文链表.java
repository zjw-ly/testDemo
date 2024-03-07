package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

import java.util.Stack;

/**
 * 回文链表
 *
 * @author zaochun.zjw
 * @date 2024/3/7
 */
public class Easy234回文链表 {

    public static boolean isPalindrome(ListNode head) {
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        ListNode tmp = head;
        while (tmp != null) {
            if (stack.size() / 2 == 0) {
                break;
            }

            if (tmp.val != stack.pop().val) {
                return false;
            }
            tmp = tmp.next;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
