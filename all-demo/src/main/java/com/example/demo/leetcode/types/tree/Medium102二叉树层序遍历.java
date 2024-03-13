package com.example.demo.leetcode.types.tree;

import com.example.demo.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zaochun.zjw
 * @date 2024/3/11
 */
public class Medium102二叉树层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
                tmp.add(poll.val);
            }
            res.add(tmp);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
