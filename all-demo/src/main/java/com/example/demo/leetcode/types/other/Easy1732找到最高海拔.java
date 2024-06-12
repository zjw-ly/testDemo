package com.example.demo.leetcode.types.other;

/**
 * * 1732找到最高海拔
 * * <p>
 * * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 * * <p>
 * * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 * * <p>
 * * <p>
 * * <p>
 * * 示例 1：
 * * <p>
 * * 输入：gain = [-5,1,5,0,-7]
 * * 输出：1
 * * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * * 示例 2：
 * * <p>
 * * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * * 输出：0
 * * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 *
 * @author zaochun.zjw
 * @date 2024/5/30
 */
public class Easy1732找到最高海拔 {

    public int largestAltitude(int[] gain) {
        int[] res = new int[gain.length + 1];
        int max = 0;
        res[0] = 0;
        for (int i = 0; i < gain.length; i++) {
            res[i + 1] = res[i] + gain[i];
            max = Math.max(max, res[i + 1]);
        }

        return max;
    }
}
