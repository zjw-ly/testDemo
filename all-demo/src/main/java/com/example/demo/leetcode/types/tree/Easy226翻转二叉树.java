package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

/**
 * 翻转二叉树
 *
 * @author zaochun.zjw
 * @date 2024/3/11
 */
public class Easy226翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        reverse(root);
        return root;
    }

    public void reverse(TreeNode treeNode) {
        if (treeNode.right != null || treeNode.left != null) {
            TreeNode tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;
        }
        if (treeNode.left != null) reverse(treeNode.left);
        if (treeNode.right != null) reverse(treeNode.right);
    }
}
