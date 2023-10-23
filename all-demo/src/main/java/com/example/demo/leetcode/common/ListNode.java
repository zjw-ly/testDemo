package com.example.demo.leetcode.common;

/**
 * 列表
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
