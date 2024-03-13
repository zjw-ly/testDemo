package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zaochun.zjw
 * @date 2024/3/11
 */
public class TMedium98验证二叉搜索树 {

    public static void main(String[] args) {
        TMedium98验证二叉搜索树 tmp = new TMedium98验证二叉搜索树();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println(tmp.isValidBST(root));
    }

    List<Integer> res;

    public boolean isValidBST(TreeNode root) {

        res = new ArrayList<>();
        if (root == null) {
            return true;
        }
        BST(root);

        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public void BST(TreeNode root) {
        if (root == null) {
            return;
        }
        BST(root.left);
        res.add(root.val);
        BST(root.right);
    }


    // Second Parse
    public boolean isValidBSTTest(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
