package com.example.demo.leetcode.types.slidewindow.l75;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * @author zaochun.zjw
 * @date 2024/5/29
 */
public class Medium1004最大连续1的个数III {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,1,0,0}, 0));
    }

    public static int longestOnes(int[] nums, int k) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        int tmpK = k;

        if(k >= nums.length){
            return k;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmpK == 0) {
                break;
            }

            if (nums[i] == 0) {
                nums[i] = 1;
                queue.offer(i);
                tmpK--;
            }
        }

        int left = 0;
        int right = 0;
        int tmp = 0;
        while (right < nums.length) {
            if (right < nums.length && nums[right] != 0) {
                right++;
                continue;
            }

            tmp = Math.max(tmp, right - left);
            if (queue.isEmpty()) {
                left = right + 1;
                right = left;
            } else {
                Integer poll = queue.poll();
                queue.offer(right);
                left = poll + 1;
                nums[right] = 1;
            }
        }

        tmp = Math.max(tmp,nums.length - left);

        return tmp;
    }
}
