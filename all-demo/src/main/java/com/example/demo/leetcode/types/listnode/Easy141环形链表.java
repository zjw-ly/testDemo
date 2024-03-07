package com.example.demo.leetcode.types.listnode;

import com.example.demo.leetcode.common.ListNode;

/**
 * 环形链表
 *
 * @author zaochun.zjw
 * @date 2024/3/7
 */
public class Easy141环形链表 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode normal = head.next;
        ListNode fast = head.next.next;
        while (normal != null && fast !=null){
            if(normal == fast){
                return true;
            }

            normal = normal.next;
            if(fast.next == null){
                return false;
            }
            fast = fast.next.next;
        }

        return false;
    }
}
