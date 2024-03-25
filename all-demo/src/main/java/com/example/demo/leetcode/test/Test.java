package com.example.demo.leetcode.test;

import java.util.*;

/**
 * @author zaochun.zjw
 * @date 2024/3/5
 */
public class Test {

    public static void main(String[] args) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(Integer integer : map.get(2)){
            System.out.println(integer);
        }
    }

    // * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
    // * <p>
    // * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
    // * <p>
    // * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    // * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
    // * <p>
    // * 示例 1：
    // * <p>
    // * 输入：numCourses = 2, prerequisites = [[1,0]]
    // * 输出：true
    // * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
    // * 示例 2：
    // * <p>
    // * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
    // * 输出：false
    // * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] num = prerequisites[i];
            int preClass = num[1];
            List<Integer> outClass = map.getOrDefault(preClass, new ArrayList<>());
            outClass.add(num[0]);
            map.put(preClass, outClass);
        }

        int[] preNum = new int[numCourses];
        for (Map.Entry<Integer, List<Integer>> listEntry : map.entrySet()) {
            for (Integer value : listEntry.getValue()) {
                preNum[value]++;
            }
        }

        int resPre = 0;
        Queue<Integer> noPre = new LinkedList<>();
        for (int i = 0; i < preNum.length; i++) {
            noPre.offer(i);
            resPre++;
        }

        if (resPre == 0) {
            return false;
        }

        while (!noPre.isEmpty()) {
            Integer preKey = noPre.poll();
            if(map.containsKey(preKey)){
                for (Integer value : map.get(preKey)) {
                    preNum[value]--;
                    if (preNum[value] == 0) {
                        noPre.offer(value);
                        resPre++;
                    }
                }
            }

        }

        return resPre == numCourses;
    }
}
