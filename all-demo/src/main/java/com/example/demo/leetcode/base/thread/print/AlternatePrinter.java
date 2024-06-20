package com.example.demo.leetcode.base.thread.print;

/**
 * 实现线程的打印类
 *
 * @author zaochun.zjw
 * @date 2024/6/13
 */
public class AlternatePrinter implements Runnable{

    private final String name;
    private final Object lock;
    private final int turn;
    private static volatile int count = 0;
    private final int totalTurns;

    public AlternatePrinter(String name, Object lock, int turn, int totalTurns) {
        this.name = name;
        this.lock = lock;
        this.turn = turn;
        this.totalTurns = totalTurns;
    }

    @Override
    public void run() {
        while(count <= totalTurns){
            synchronized (lock) {
                while (count % 2 != turn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Thread interrupted: " + name);
                        return;
                    }
                }
                if (count < totalTurns) {
                    System.out.println(name);
                    count++;
                    lock.notifyAll();
                }
            }
        }
    }
}
