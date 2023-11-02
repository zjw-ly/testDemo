package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和2
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * @author zaochun.zjw
 * @date 2023/10/24
 */
public class Medium40组合总和2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        dps(candidates, target, res, tmp, 0);
        return res;
    }

    public void dps(int[] nums, int target, List<List<Integer>> res, List<Integer> tmp, int index) {

        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            tmp.add(nums[i]);
            dps(nums, target - nums[i], res, tmp, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Medium40组合总和2 medium40组合总和2 = new Medium40组合总和2();
        medium40组合总和2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).stream().forEach(it -> {
            System.out.println("结果数据为");
            it.stream().forEach(that -> {
                System.out.print(that);
            });
            System.out.println("");
        });
    }
}
