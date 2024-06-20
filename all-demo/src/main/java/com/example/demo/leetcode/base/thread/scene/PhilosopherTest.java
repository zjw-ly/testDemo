package com.example.demo.leetcode.base.thread.scene;

import java.util.concurrent.Semaphore;

/**
 * 哲学家问题测试
 *
 * @author zaochun.zjw
 * @date 2024/6/20
 */
public class PhilosopherTest {

    public static void main(String[] args) {
        int forSize = 5;
        Semaphore[] fork = new Semaphore[5];
        for (int i = 0; i < forSize; i++) {
            fork[i] = new Semaphore(1);
        }
        Semaphore maxCanUseFork = new Semaphore(forSize - 1);

        int personSize = 5;
        Thread person[] = new Thread[personSize];
        for (int i = 0; i < personSize; i++) {
            person[i] = new Thread(new PhilosopherProblem(String.format("Thread-%s",i),fork[i],fork[(i+1) % forSize],maxCanUseFork));
            person[i].start();
        }
    }
}
