package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 */
public class Medium18四数之和 {


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Long targetLong = (long)target;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3;) {

            for (int j = i + 1; j < nums.length - 2; ) {
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if ((long) nums[i] + nums[j] + nums[left] + nums[right] == targetLong) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if ((long) nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        while (left < right && nums[left] == nums[++left]) ;
                    } else if ((long) nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }

                while (j < nums.length - 2 && nums[j] == nums[++j]);
            }

            while (i < nums.length - 3 && nums[i] == nums[++i]) ;
        }

        return res;
    }

    public static void main(String[] args) {
        long a=(long) 1000000000 + 1000000000 + 1000000000 + 1000000000;
        System.out.println("a的值"+a);

        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
}
