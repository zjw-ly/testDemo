package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @author zaochun.zjw
 * @date 2023/10/30
 */
public class Medium46全排列 {

    public static void main(String[] args) {
        Medium46全排列 medium46全排列 = new Medium46全排列();
        medium46全排列.permute(new int[]{1, 2, 3}).stream().forEach(it -> {
            System.out.println("排列");
            it.stream().forEach(that -> {
                System.out.print(that + ",");
            });
        });
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
