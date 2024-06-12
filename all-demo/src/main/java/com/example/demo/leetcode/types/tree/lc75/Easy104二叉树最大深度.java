package com.example.demo.leetcode.types.tree.lc75;

import com.example.demo.leetcode.common.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 *
 * @author zaochun.zjw
 * @date 2024/6/4
 */
public class Easy104二叉树最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for(int i = 0;i<size;i++){
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        return count;
    }
}
