package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

/**
 * 对称二叉树
 *
 * @author zaochun.zjw
 * @date 2024/3/11
 */
public class TEasy101对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isDuiChen(root.left, root.right);
    }

    public boolean isDuiChen(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isDuiChen(left.left, right.right) && isDuiChen(left.right, right.left);
    }
}
