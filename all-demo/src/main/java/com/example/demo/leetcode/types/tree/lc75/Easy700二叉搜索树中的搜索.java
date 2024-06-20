package com.example.demo.leetcode.types.tree.lc75;

import com.example.demo.leetcode.common.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * <p>
 * 示例 1:
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * <p>
 * 示例 2:
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * 树中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 107
 * root 是二叉搜索树
 * 1 <= val <= 107
 *
 * @author zaochun.zjw
 * @date 2024/6/13
 */
public class Easy700二叉搜索树中的搜索 {

    public static void main(String[] args) {
        Easy700二叉搜索树中的搜索 tmp = new Easy700二叉搜索树中的搜索();

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);

        TreeNode treeNode1 = tmp.searchBST(treeNode, 2);

        System.out.println(tmp.res);
    }

    public TreeNode res;
    public TreeNode searchBST(TreeNode root, int val) {
        res = null;
        DFS(root,val);
        return res;
    }

    public void DFS(TreeNode root,int val){
        if (root.val == val) {
            res = root;
            return;
        }

        if (root.left != null) {
            DFS(root.left, val);
        }

        if (root.right != null) {
            DFS(root.right, val);
        }

        return;
    }
}
