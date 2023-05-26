package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author zaochun.zjw
 * @date 2023/4/13
 */
public class Easy1 {

    public int[] twoSum(int[] nums, int target) {
        //典型的时间换空间问题，将每一个元素值&位置 存在map中，遍历整个数组，若map中存在元素满足 与当前值之和为target 则直接退出
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
