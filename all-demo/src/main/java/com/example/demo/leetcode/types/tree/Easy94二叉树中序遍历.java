package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @author zaochun.zjw
 * @date 2024/3/11
 */
public class Easy94二叉树中序遍历 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        zxEach(root);
        return res;
    }

    void zxEach(TreeNode root) {
        if (root == null) {
            return;
        }

        zxEach(root.left);
        res.add(root.val);
        zxEach(root.right);
    }
}
