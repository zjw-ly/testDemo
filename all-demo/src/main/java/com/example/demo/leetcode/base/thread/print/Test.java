package com.example.demo.leetcode.base.thread.print;

/**
 * @author zaochun.zjw
 * @date 2024/6/13
 */
public class Test implements Runnable {

    private static volatile int count = 0;

    private final String name;

    private final Object lock;

    private final int markSize;

    private final int sumSize;

    public Test(String name, Object lock, int markSize, int sumSize) {
        this.name = name;
        this.lock = lock;
        this.markSize = markSize;
        this.sumSize = sumSize;
    }

    @Override
    public void run() {
        while (count < sumSize) {
            synchronized (lock) {
                if(count % 2 == markSize){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if(count < sumSize){
                    System.out.println(name);
                    count++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        int countSize = 10;
        Test test1 = new Test("Thread1", lock, 0, countSize);
        Test test2 = new Test("Thread2", lock, 1, countSize);
        Thread thread1 = new Thread(test1);
        Thread thread2 = new Thread(test2);

        thread1.start();
        thread2.start();
    }
}
