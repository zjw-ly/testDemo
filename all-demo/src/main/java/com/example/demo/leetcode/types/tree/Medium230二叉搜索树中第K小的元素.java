package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zaochun.zjw
 * @date 2024/3/11
 */
public class Medium230二叉搜索树中第K小的元素 {

    Queue<Integer> queue;

    public int kthSmallest(TreeNode root, int k) {
        queue = new ArrayDeque<>();
        each(root);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }

        return res;
    }

    public void each(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        each(treeNode.left);
        queue.offer(treeNode.val);
        each(treeNode.right);
    }
}
