package com.example.demo.leetcode.types.greedy;

/**
 * 跳跃游戏
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * @author zaochun.zjw
 * @date 2024/3/20
 */
public class Medium55跳跃游戏 {

    public static void main(String[] args) {
        System.out.println(Medium55跳跃游戏.canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        for (int i = 0; i < nums.length; ) {
            int loc = i;
            int nextLoc = i;
            for (int j = i; j <= nums[i] + i && j < nums.length; j++) {
                if(j + nums[j] > loc){
                    loc = j + nums[j];
                    nextLoc = j;
                }
            }

            if(loc >= nums.length - 1){
                return true;
            }

            if (nextLoc == i) {
                return false;
            }

            i = nextLoc;
        }

        return false;
    }
}
