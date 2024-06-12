package com.example.demo.leetcode.types.tree.lc75;

import com.example.demo.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * <p>
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,1,4,3,null,1,5]
 * 输出：4
 * 解释：图中蓝色节点为好节点。
 * 根节点 (3) 永远是个好节点。
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,3,null,4,2]
 * 输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * 解释：根节点是好节点。
 *
 * @author zaochun.zjw
 * @date 2024/6/5
 */
public class Medium1448统计二叉树中好节点的数目 {

    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    if (poll.left.val >= poll.val) {
                        count++;
                    }else{
                        poll.left.val = poll.val;
                    }

                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    if (poll.right.val >= poll.val) {
                        count++;
                    }else{
                        poll.right.val = poll.val;
                    }

                    queue.offer(poll.right);
                }
            }
        }

        return count;
    }
}
