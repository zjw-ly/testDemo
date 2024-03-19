package com.example.demo.leetcode.types.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法 ： 递归 + 循环 + 减枝（什么情况下用到剪枝呢 ： 降低时间复杂度）
 * 回溯算法的框架：
 *
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 *
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * Related Topics
 * 数组
 * 回溯
 *
 * @author zaochun.zjw
 * @date 2024/3/14
 */
public class F回溯法Medium46全排列 {

    public static void main(String[] args) {
        F回溯法Medium46全排列 tmp = new F回溯法Medium46全排列();
        tmp.permute(new int[]{1,2,3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        digui(nums, tmp, res);
        return res;
    }

    public void digui(int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!tmp.contains(nums[i])) {
                tmp.add(nums[i]);
                digui(nums, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
