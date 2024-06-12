package com.example.demo.leetcode.types.tree.lc75;

import com.example.demo.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * <p>
 * 提示：
 * 给定的两棵树结点数在 [1, 200] 范围内
 * 给定的两棵树上的值在 [0, 200] 范围内
 *
 * @author zaochun.zjw
 * @date 2024/6/4
 */
public class Easy872叶子相似的树 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = getLeaf(root1);
        List<Integer> root2List = getLeaf(root2);
        if(root1List.size() != root2List.size()){
            return false;
        }
        for(int i = 0;i<root1List.size();i++){
            if(root1List.get(i) != root2List.get(i)){
                return false;
            }
        }

        return true;
    }

    public List<Integer> getLeaf(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        if (treeNode == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left == null && poll.right == null){
                    list.add(poll.val);
                }

                if(poll.left!=null){
                    queue.offer(poll.left);
                }

                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }

        return list;
    }
}
