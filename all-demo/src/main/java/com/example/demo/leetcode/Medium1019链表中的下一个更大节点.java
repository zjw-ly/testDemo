package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 链表中的下一个更大节点
 *
 * @author zaochun.zjw
 * @date 2023/4/10
 */
public class Medium1019链表中的下一个更大节点 {

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

    /**
     * 测试算法 : 思路 -> 双指针执行 用不回头
     *
     * @param head 头节点
     * @return 算法
     */
    public static int[] nextLargerNodes(ListNode head) {
        ListNode a = head;
        ArrayList<Integer> list = new ArrayList<>();

        while (a != null) {
            ListNode b = a.next;

            int count = 0;
            while (b != null) {

                if (a.val < b.val) {
                    count++;
                    list.add(b.val);
                    break;
                } else {
                    b = b.next;
                }
            }
            if (count == 0) {
                list.add(0);
            }

            a = a.next;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 单调栈执行操作
     *
     * @param head 指针
     * @return 单调栈
     */
    public static int[] nextLargerNodesStandard(ListNode head) {
        ListNode l = head;
        int length = 0;
        while (l != null) {
            l = l.next;
            length++;
        }
        int[] ints = new int[length];
        int index = 0;

        // 栈保存的是数据下标（通过下标定位元素）、代表需要判断的元素 尚未出现满足条件的后置元素
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;

        //遍历链表
        while (node != null) {
            //（刚开始此位置存的是：元素本身、后来存的是元素的目标值）把当前元素放入链表
            ints[index] = node.val;
            // 遇到栈顶元素比当前元素小，则弹出
            while (!stack.isEmpty() && ints[stack.peek()] < ints[index]) {
                //弹出元素 说明当前元素是弹出元素的下一个更大节点
                int c = stack.pop();
                ints[c] = ints[index];
            }
            stack.add(index);
            //处理下一个元素
            node = node.next;
            index++;
        }

        //遍历结束 栈不为空，栈内的元素都是右面没有比它大的元素 直接赋值为0
        while (!stack.isEmpty()) {
            int c = stack.pop();
            ints[c] = 0;
        }
        return ints;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(7);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Arrays.stream(nextLargerNodesStandard(a)).forEach(System.out::println);
    }
}
