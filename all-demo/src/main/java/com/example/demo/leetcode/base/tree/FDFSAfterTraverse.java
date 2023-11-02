package com.example.demo.leetcode.base.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 后序遍历
 *
 * @author zaochun.zjw
 * @date 2023/10/25
 */
public class FDFSAfterTraverse {

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
        noDfsTest(node);
    }

    public static void dfs(TreeNode treeNode) {
        if (treeNode != null) {
            dfs(treeNode.left);
            dfs(treeNode.right);
            System.out.println(treeNode.val);
        }
    }

    public static void noDfsTest(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = treeNode;
        TreeNode lastNode = treeNode;
        while(node!=null ||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }

            node = stack.peek();
            if (node.right == null || node.right == lastNode){
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                lastNode = node;
                node = null;
            }else {
                node = node.right;
            }
        }
    }



    /** —————————— 后序遍历：非递归 —————————— */
    public static void noDfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastNode = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            // 查看当前栈顶元素
            node = treeNodeStack.peek();
            // 如果其右子树也为空，或者右子树已经访问过，则可以直接输出当前节点的值
            if (node.right == null || node.right == lastNode) {
                System.out.print("输出节点：" + node.val);
                treeNodeStack.pop();
                // 把输出的节点赋值给lastNode游标，作为下次比对的依据
                lastNode = node;
                node = null;
            } else {
                node = node.right;
            }
        }
    }
}
