package com.example.demo.leetcode.test;

import com.example.demo.leetcode.common.TreeNode;
import com.example.demo.leetcode.types.tree.Medium437路径总和;

/**
 * @author zaochun.zjw
 * @date 2024/3/5
 */
public class Test {

    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        diG(root);
        return max;
    }

    public int diG(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int left = diG(treeNode.left);
        int right = diG(treeNode.right);

        if (left < 0) {
            return 0;
        }

        if (right < 0) {
            return 0;
        }

        max = Math.max(max, treeNode.val + left + right);
        return Math.max(left, right) + treeNode.val;
    }

    public static void main(String[] args) {
        Integer a = -2000000000;
        System.out.println(a - 294967296);

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Test test = new Test();
        System.out.println(test.maxPathSum(root));
    }
}
