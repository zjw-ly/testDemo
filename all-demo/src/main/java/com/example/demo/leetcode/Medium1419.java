package com.example.demo.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 数青蛙
 *
 * @author zaochun.zjw
 * @date 2023/5/6
 */
public class Medium1419 {

    public static int minNumberOfFrogs(String croakOfFrogs) {
        int flag = 0;
        Queue<Integer> asCList = new LinkedBlockingQueue<Integer>() {};
        Queue<Integer> asRList = new LinkedBlockingQueue<Integer>() {};
        Queue<Integer> asOList = new LinkedBlockingQueue<Integer>() {};
        Queue<Integer> asAList = new LinkedBlockingQueue<Integer>() {};
        Queue<Integer> asKList = new LinkedBlockingQueue<Integer>() {};

        char[] chars = croakOfFrogs.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'c') {
                asCList.add(i);
            } else if (chars[i] == 'r') {
                if (asCList.isEmpty()) {
                    asCList.poll();
                    continue;
                }

                asRList.add(i);
            } else if (chars[i] == 'o') {
                if (asRList.isEmpty()) {
                    asRList.poll();
                    continue;
                }

                asOList.add(i);
            } else if (chars[i] == 'a') {
                if (asOList.isEmpty()) {
                    asOList.poll();
                    continue;
                }

                asAList.add(i);
            } else if (chars[i] == 'k') {
                if (asAList.isEmpty()) {
                    asAList.poll();
                    continue;
                }

                asKList.add(i);
                asCList.poll();
                asRList.poll();
                asOList.poll();
                asAList.poll();
                asKList.poll();
                flag++;
            }
        }

        return flag > 0 ? flag : -1;
    }

    public static void main(String[] args) {
        String str = "crcoakroak";
        System.out.println(minNumberOfFrogs(str));
    }
}
