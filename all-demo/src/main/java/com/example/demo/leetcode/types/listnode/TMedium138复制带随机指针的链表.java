package com.example.demo.leetcode.types.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zaochun.zjw
 * @date 2024/3/9
 */
public class TMedium138复制带随机指针的链表 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node,Node> hashMap = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            hashMap.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        Node tmp = head;
        while(tmp != null){
            hashMap.get(tmp).next = hashMap.get(tmp.next);
            hashMap.get(tmp).random = hashMap.get(tmp.random);
            tmp = tmp.next;
        }

        return hashMap.get(head);
    }


}
