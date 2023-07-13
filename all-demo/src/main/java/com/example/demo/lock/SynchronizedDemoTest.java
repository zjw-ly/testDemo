package com.example.demo.lock;

import lombok.Data;

import java.util.concurrent.*;

/**
 * 枷锁
 *
 * @author zaochun.zjw
 * @date 2023/7/5
 */
@Data
public class SynchronizedDemoTest {

    public static void main(String[] args) {

        SynchronizedDemoTest synchronizedDemoTest = new SynchronizedDemoTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        completionService.submit(() -> SynchronizedDemoTest.method1());
        completionService.submit(() -> SynchronizedDemoTest.method1());
        completionService.submit(() -> SynchronizedDemoTest.method1());
        completionService.submit(() -> SynchronizedDemoTest.method1());
        completionService.submit(() -> SynchronizedDemoTest.method1());
        completionService.submit(() -> SynchronizedDemoTest.method1());
        completionService.submit(() -> SynchronizedDemoTest.method1());
        completionService.submit(() -> SynchronizedDemoTest.method1());
    }

    public static synchronized String method1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("===>method1<===" + Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }
}
