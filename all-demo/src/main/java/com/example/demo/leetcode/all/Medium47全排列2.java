package com.example.demo.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列2
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @author zaochun.zjw
 * @date 2023/10/30
 */
public class Medium47全排列2 {

    public static void main(String[] args) {
        Medium47全排列2 medium47全排列 = new Medium47全排列2();
        medium47全排列.permuteUnique(new int[]{1, 2, 3}).stream().forEach(it -> {
            System.out.println("排列");
            it.stream().forEach(that -> {
                System.out.print(that + ",");
            });
        });
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        List<Integer> location = new ArrayList<>();

        digui(nums, tmp, res, location);
        return res;
    }

    public void digui(int[] nums, List<Integer> tmp, List<List<Integer>> res, List<Integer> location) {
        if (tmp.size() == nums.length) {
            if(!res.contains(tmp)){
                res.add(new ArrayList<>(tmp));
            }

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!location.contains(i)) {
                tmp.add(nums[i]);
                location.add(i);
                digui(nums, tmp, res, location);
                tmp.remove(tmp.size() - 1);
                location.remove(location.size() - 1);
            }
        }
    }
}
