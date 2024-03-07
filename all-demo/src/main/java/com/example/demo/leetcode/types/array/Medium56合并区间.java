package com.example.demo.leetcode.types.array;

import java.util.*;

/**
 * 合并区间、
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author zaochun.zjw
 * @date 2024/3/7
 */
public class Medium56合并区间 {

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        res.toArray();
//[5,5],[1,3],[3,5],[4,6],[1,1],[3,3],[5,6],[3,3],[2,4],[0,0]
        int[][] tmp = {{5, 5}, {1, 3}, {3, 5}, {4, 6}, {1, 1}, {3, 3}, {5, 6}, {2, 4}, {0, 0}};
        Arrays.stream(merge(tmp)).forEach(it -> {
            for (int i = 0; i < it.length; i++) {
                System.out.print(it[i]);
            }
            System.out.println();
        });
    }

    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] != o1[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            queue.offer(new int[]{intervals[i][0],intervals[i][1]});
        }

        int index = 0;
        while (queue.size() != 0) {
            int[] poll = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(poll[0]);
            int max = poll[1];
            while (queue.size() != 0 && queue.peek()[0] <= max) {
                int[] pollNext = queue.poll();
                max = Math.max(max, pollNext[1]);
            }
            tmp.add(max);
            res.add(tmp);
            index++;
        }

        int[][] resNum = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < 2; j++) {
                resNum[i][j] = res.get(i).get(j);
            }
        }
        return resNum;
    }
}
