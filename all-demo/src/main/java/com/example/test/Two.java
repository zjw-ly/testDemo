package com.example.test;

import java.util.*;

/**
 * 4
 * 100 100 120 130
 * 40 30 60 50
 *
 * @author zaochun.zjw
 * @date 2024/4/29
 */
public class Two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] height = new int[num];
        int[] weight = new int[num];
        for (int i = 0; i < num; i++) {
            height[i] = scanner.nextInt();
        }

        for (int i = 0; i < num; i++) {
            weight[i] = scanner.nextInt();
        }

        Arrays.stream(sort(height, weight)).forEach(it -> System.out.print(it + " "));
    }

    /**
     * 排序
     *
     * @param height
     * @param weight
     * @return
     */
    public static int[] sort(int[] height, int[] weight) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(1) == o2.get(1) && o1.get(2) == o2.get(2)) {
                    return o1.get(0) - o2.get(0);
                }

                return o1.get(1) - o2.get(1) == 0 ? o1.get(2) - o2.get(2) : o1.get(1) - o2.get(1);
            }
        });

        for (int i = 0; i < height.length; i++) {
            List<Integer> tmp = Arrays.asList(i, height[i], weight[i]);
            queue.add(tmp);
        }

        int[] res = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            List<Integer> poll = queue.poll();
            res[i] = poll.get(0) + 1;
        }

        return res;
    }
}
