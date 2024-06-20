package com.example.demo.leetcode.base.thread.print;

/**
 * @author zaochun.zjw
 * @date 2024/6/13
 */
public class Main {

    public static void main(String[] args) {
        Object lock = new Object();
        int totalTurns = 10; // 总共打印10次

        Thread t1 = new Thread(new AlternatePrinter("Thread-1", lock, 0, totalTurns));
        Thread t2 = new Thread(new AlternatePrinter("Thread-2", lock, 1, totalTurns));

        t1.start();
        t2.start();
    }
}
