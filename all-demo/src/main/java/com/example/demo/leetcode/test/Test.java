package com.example.demo.leetcode.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @date 2024/3/5
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int[] sliver = new int[nextInt];
        for (int i = 0; i < nextInt; i++) {
            sliver[i] = scanner.nextInt();
        }

        System.out.println(getMaxWeight(sliver));
    }

    public static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public static int getMaxWeight(int[] sliver) {


        for (int i = 0; i < sliver.length; i++) {
            priorityQueue.offer(sliver[i]);
        }

        while (!priorityQueue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if (priorityQueue.isEmpty()) {
                    break;
                }
                tmp.add(priorityQueue.poll());
            }

            if (tmp.size() < 3) {
                if (tmp.size() == 0) {
                    return 0;
                }
                if (tmp.size() == 1) {
                    return tmp.get(0);
                }

                return Math.max(tmp.get(0), tmp.get(1));
            }

            melt( tmp);
        }

        return 0;
    }

    /**
     * 熔炼
     *
     * @param tmp
     */
    public static void melt(ArrayList<Integer> tmp) {
        for (int i = 0; i < tmp.size() -1; i++) {
            if (tmp.get(i) - tmp.get(i + 1) > 0) {
                priorityQueue.offer(tmp.get(i) - tmp.get(i + 1));
            }
        }
    }
}