package com.example.demo.leetcode.base.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 先序遍历 中左右
 *
 * @author zaochun.zjw
 * @date 2023/10/25
 */
public class DFSPreTraverse {

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

        dfs(node);
        System.out.println("-----------------");
        noDfs(node);
    }

    /**
     * 递归
     *
     * @param treeNode 树
     */
    public static void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        if (treeNode != null) {
            System.out.println(treeNode.val);
            dfs(treeNode.left);
            dfs(treeNode.right);
        }
    }

    public static void noDfs(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {

            while (treeNode != null) {
                System.out.println(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                treeNode = pop.right;
            }
        }
    }
}
