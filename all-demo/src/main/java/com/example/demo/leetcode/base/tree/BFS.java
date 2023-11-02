package com.example.demo.leetcode.base.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 广度优先搜索算法
 *
 * @author zaochun.zjw
 * @date 2023/10/25
 */
public class BFS {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);

        bfs(node);
        System.out.println("-----------------");
    }

    public static void bfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                System.out.println(poll.val);
                if (poll.left != null){
                    queue.add(poll.left);
                }

                if(poll.right !=null){
                    queue.add(poll.right);
                }
            }
        }
    }
}
