package com.example.demo.leetcode.base.thread.scene;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 哲学家问题
 *
 * @author zaochun.zjw
 * @date 2024/6/20
 */
public class PhilosopherProblem implements Runnable {

    public final String threadName;

    public final Semaphore left;

    public final Semaphore right;

    public final Semaphore max;

    public final Random random;

    public PhilosopherProblem(String threadName, Semaphore left, Semaphore right, Semaphore max) {
        this.threadName = threadName;
        this.left = left;
        this.right = right;
        this.max = max;
        this.random = new Random();
    }


    @Override
    public void run() {
        try {
            while (true){
                eat();
                think();
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    public void eat() throws InterruptedException {
        max.acquire();
        left.acquire();
        right.acquire();
        System.out.println(threadName + " is eating");
        Thread.sleep((random.nextInt(10) + 1) * 1000);
        //System.out.println(threadName + " eating over");
        right.release();
        left.release();
        max.release();
    }

    public void think() throws InterruptedException {
        System.out.println(threadName + " is thinking");
        Thread.sleep((random.nextInt(10) + 1) * 1000);
        //System.out.println(threadName + " thinking over");
    }
}
