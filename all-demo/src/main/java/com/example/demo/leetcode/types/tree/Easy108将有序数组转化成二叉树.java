package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

/**
 * @author zaochun.zjw
 * @date 2024/3/11
 */
public class Easy108将有序数组转化成二叉树 {


    public TreeNode sortedArrayToBST(int[] nums) {
       return change(0,nums.length-1, nums);
    }

    public TreeNode change(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode tree = new TreeNode(nums[mid]);
        tree.left = change(left, mid, nums);
        tree.right = change(mid + 1, right, nums);
        return tree;
    }
}
