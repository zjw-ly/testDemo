package com.example.demo.leetcode.types.skill;

import java.util.HashMap;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * @author zaochun.zjw
 * @date 2024/4/23
 */
public class Medium75颜色分类 {

    public static void main(String[] args) {
        int[] num = new int[]{0};
        sortColors(num);
        System.out.println(1);
    }

    public static void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer value : nums) {
            Integer defaultValue = map.getOrDefault(value, 0);
            map.put(value, ++defaultValue);
        }

        int index = 0;
        for (int i = 0;map.containsKey(0) &&  i < map.get(0); i++) {
            nums[index] = 0;
            index++;
        }
        for (int i = 0;map.containsKey(1) &&  i < map.get(1); i++) {
            nums[index] = 1;
            index++;
        }
        for (int i = 0;map.containsKey(2) &&  i < map.get(2); i++) {
            nums[index] = 2;
            index++;
        }
    }
}
