package com.example.demo.leetcode.base.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 中序遍历
 *
 * @author zaochun.zjw
 * @date 2023/10/25
 */
public class DFSMidTraverse {

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

    public static void dfs(TreeNode treeNode){
        if(treeNode!=null){
            dfs(treeNode.left);
            System.out.println(treeNode.val);
            dfs(treeNode.right);
        }
    }

    public static void noDfs(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while(treeNode!=null || !stack.isEmpty()){

            while (treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                treeNode = pop.right;
            }
        }
    }
}
