package com.example.demo.leetcode.types.tree.lc75;

import com.example.demo.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * <p>
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * 请你返回给定树中最长 交错路径 的长度。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * <p>
 * 示例 2：
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：0
 *
 * @author zaochun.zjw
 * @date 2024/6/5
 */
public class FMedium1372二叉树中的最长交错路径 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(6);
        treeNode.right.right.left.right = new TreeNode(7);
        treeNode.right.right.left.right.right = new TreeNode(8);

        FMedium1372二叉树中的最长交错路径 medium = new FMedium1372二叉树中的最长交错路径();
        System.out.println(medium.longestZigZag(treeNode));
    }

    private int max = 0;

    public int longestZigZag(TreeNode root) {
        visit(root, 0, 0);
        return max;
    }

    private void visit(TreeNode root, int leftMax, int rightMax) {
        max = Math.max(max, Math.max(leftMax, rightMax));

        if (root == null) {
            return;
        }

        if (root.left != null) {
            visit(root.left, rightMax + 1, 0);
        }

        if (root.right != null) {
            visit(root.right, 0, leftMax + 1);
        }
    }

    //采用深度优先遍历的方式，我们可以从顶向下访问到所有节点。并且遍历下一个子节点时，我们也能够知道子节点是属于父节点的左子树，还是右子树。
    //
    //所以我们可以为每个节点缓存两个值，一个l表示到达当前节点时，该节点为左子树时的路径数，一个r表示该节点为右子树时的到达路径。
    //当然，一个节点要么是左子树，要么是右子树，所以l和r其中只有一个有值。
    //
    //那么在遍历该节点的子节点时，如果子节点是左子树，那么它的l值就是父节点的r值加1. 如果是右子树，就是父节点的l值加1
}
