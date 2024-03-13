package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

/**
 * 最大路径之和
 *
 * @author zaochun.zjw
 * @date 2024/3/12
 */
public class FHard124最大路径之和 {
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
            left =  0;
        }

        if (right < 0) {
            right = 0;
        }

        max = Math.max(max, treeNode.val + left + right);
        return Math.max(left, right) + treeNode.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(-1);

        FHard124最大路径之和 fHard124最大路径之和 = new FHard124最大路径之和();
        System.out.println(fHard124最大路径之和.diG(treeNode));
    }
}
