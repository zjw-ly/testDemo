package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 路径总和III
 * <p>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 * @author zaochun.zjw
 * @date 2024/3/12
 */
public class Medium437路径总和 {


    public static void main(String[] args) {
        Integer a = -2000000000;
        System.out.println(a - 294967296);

        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.right = new TreeNode(1000000000);

        Medium437路径总和 medium437路径总和 = new Medium437路径总和();
        System.out.println(medium437路径总和.pathSum(root, 0));
    }

    int res;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                long val = poll.val;
                digui(poll, targetSum - val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return res;
    }

    public void digui(TreeNode treeNode, long targetSum) {
        if (targetSum == 0) {
            res++;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return;
        }

        if (treeNode.left != null) digui(treeNode.left, targetSum - treeNode.left.val);
        if (treeNode.right != null) digui(treeNode.right, targetSum - treeNode.right.val);
    }
}
