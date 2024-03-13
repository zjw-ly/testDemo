package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

/**
 * 二叉树的直径
 *
 * @author zaochun.zjw
 * @date 2024/3/11
 */
public class FEasy543二叉树的直径 {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        getDepth(root);
        return ans - 1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int L = getDepth(root.left);
        int R = getDepth(root.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
