package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author zaochun.zjw
 * @date 2024/3/12
 */
public class FMedium105从前序与中序遍历序列构造二叉树 {

    Map<Integer, Integer> map;

    public TreeNode foreach(int[] preorder, int[] order, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int headVal = preorder[preLeft];
        int midLoc = map.get(headVal);

        TreeNode treeNode = new TreeNode(headVal);
        int leftTreeLen = midLoc - inLeft;
        treeNode.left = foreach(preorder, order, preLeft + 1, leftTreeLen + preLeft, inLeft, midLoc - 1);
        treeNode.right = foreach(preorder, order, leftTreeLen + preLeft +1, preRight, midLoc + 1, inRight);
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return foreach(preorder,inorder,0,n-1,0,n-1);
    }
}
