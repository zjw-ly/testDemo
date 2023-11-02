package com.example.demo.leetcode.common;

import lombok.Data;

/**
 * 树节点
 *
 * @author zaochun.zjw
 * @date 2023/10/25
 */
@Data
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    // 构造方法
    public TreeNode(int val) {
        this.val = val;
    }
}
