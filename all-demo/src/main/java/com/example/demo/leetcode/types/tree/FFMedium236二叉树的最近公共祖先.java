package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

/**
 * 二叉树的最近公共祖先
 *
 * @author zaochun.zjw
 * @date 2024/3/12
 */
public class FFMedium236二叉树的最近公共祖先 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        FFMedium236二叉树的最近公共祖先 tmp = new FFMedium236二叉树的最近公共祖先();
        TreeNode treeNode = tmp.lowestCommonAncestor(root, root.left.left, root.left.right.left);
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树的返回值都非空，说明p和q分别位于root的两侧
        if (left != null && right != null) {
            return root;
        }
        // 如果左子树为空，那么p和q都不在左子树中，返回右子树的结果
        if (left == null) {
            return right;
        }
        // 如果右子树为空，那么p和q都不在右子树中，返回左子树的结果
        if (right == null) {
            return left;
        }

        // 如果左右子树都为空，说明p和q都不在以root为根的子树中，返回null
        return null;
    }
}
