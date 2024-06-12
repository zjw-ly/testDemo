package com.example.demo.leetcode.types.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 * @author zaochun.zjw
 * @date 2024/5/30
 */
public class Easy1207独一无二出现的次数 {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer orDefault = map.getOrDefault(arr[i], 0);
            map.put(arr[i], orDefault + 1);
        }

        List<Integer> res = new ArrayList<>();
        for(Integer key : map.keySet()){
            Integer integer = map.get(key);
            if(res.contains(integer)){
                return false;
            }

            res.add(integer);
        }

        return true;
    }
}
