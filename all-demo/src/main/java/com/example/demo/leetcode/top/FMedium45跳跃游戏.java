package com.example.demo.leetcode.top;

/**
 * 跳跃游戏
 * <p>
 * 给定一个长度为n的 0索引整数数组nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 *
 * @author zaochun.zjw
 * @date 2023/10/30
 */
public class FMedium45跳跃游戏 {

    public static void main(String[] args) {
        System.out.println(jumpTest(new int[]{1,2,0,0,0,0,5}));
    }

    public static int jumpTest(int[] nums) {
        int location = 0;
        int result = 0;
        for (int i = 0; i < nums.length -1; i++) {
            if (i + nums[i] > location) {
                location = i + nums[i];
                result ++;
                if(i + nums[i] >= nums.length-1){
                    break;
                }
            }
        }

        return result;
    }

    public static int jump(int[] nums) {
        int location = 0;
        int end = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            location = Math.max(location, nums[i] + i);
            if (i == end) {
                res++;
                end = location;
            }
        }

        return res;
    }
}
