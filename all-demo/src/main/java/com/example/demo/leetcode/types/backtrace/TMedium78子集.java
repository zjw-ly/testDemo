package com.example.demo.leetcode.types.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * （幂集）。
 * 解集不能包含重复的子集。你可以按任意顺序返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author zaochun.zjw
 * @date 2024/3/14
 */
public class TMedium78子集 {

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> tmpList = new ArrayList<>();
            for (List<Integer> subList : res) {
                List<Integer> tmpSubList = new ArrayList<>(subList);
                tmpSubList.add(num);
                tmpList.add(tmpSubList);
            }
            res.addAll(tmpList);
        }

        return res;
    }
}
