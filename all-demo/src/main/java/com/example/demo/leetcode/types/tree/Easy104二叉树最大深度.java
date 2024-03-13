package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;

/**
 * 二叉树最大深度
 *
 * @author zaochun.zjw
 * @date 2024/3/11
 */
public class Easy104二叉树最大深度 {

    public int maxDepth(TreeNode root) {
        if(Objects.isNull(root)){
            return 0;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        Integer depth = 0;
        queue.offer(root);
        while (queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            depth ++;
        }

        return depth;
    }
}
