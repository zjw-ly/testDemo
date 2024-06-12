package com.example.demo.leetcode.types.tree.lc75;

import com.example.demo.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 * [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
 *
 * @author zaochun.zjw
 * @date 2024/6/5
 */
public class Medium437路径总和3 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1000000000);
        treeNode.left = new TreeNode(1000000000);
        treeNode.left.left = new TreeNode(294967296);
        treeNode.left.left.left = new TreeNode(1000000000);
        treeNode.left.left.left.left = new TreeNode(1000000000);

        System.out.println(pathSum(treeNode, 0));
    }

    public static int sum = 0;

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                dfs(poll, targetSum - poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        return sum;
    }

    public static void dfs(TreeNode root, long targetSum) {
        if (targetSum == 0) {
            sum++;
        }

        if (root.right == null && root.left == null) {
            return;
        }

        if (root.left != null) {
            dfs(root.left, targetSum - root.left.val);
        }

        if (root.right != null) {
            dfs(root.right, targetSum - root.right.val);
        }
    }
}
