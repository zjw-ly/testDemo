package com.example.demo.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * 异步测试
 *
 * @author zaochun.zjw
 * @date 2023/5/9
 */
public class ExecutorAsyncDemo {

    public static void main(String[] args) {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第一个异步任务");
        });

        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第二个异步任务");
        });

        //等待全部异步任务执行成功
        CompletableFuture.allOf(f1,f2).join();
        System.out.println("CompletableFuture Test runAsync");
    }
}
