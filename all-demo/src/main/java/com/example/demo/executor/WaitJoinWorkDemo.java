package com.example.demo.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 异步任务聚合、等待全部异步任务执行完返回
 *
 * @author zaochun.zjw
 * @date 2023/5/17
 */
public class WaitJoinWorkDemo {


    public static void main(String[] args) {
        int a = 0x7fff;
        System.out.println(a);

        WaitJoinWorkDemo js = new WaitJoinWorkDemo();
        js.waitAllAsyncTask();
    }

    /**
     * 等待执行全部异步任务
     */
    public void waitAllAsyncTask() {
        List<String> messages = Arrays.asList("a", "b", "c");

        CompletableFuture[] completableFutures = messages.stream().map(o -> {
            return asyncIssueBenefit(String.valueOf(o));
        }).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures).join();
    }

    /**
     * 异步执行任务
     *
     * @param a 任务ø
     * @return
     */
    public CompletableFuture<Void> asyncIssueBenefit(String a) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(a);
        });
    }

}
