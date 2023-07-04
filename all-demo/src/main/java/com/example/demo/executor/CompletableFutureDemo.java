package com.example.demo.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * completorFuture扩展demo
 *
 * @author zaochun.zjw
 * @date 2023/7/3
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        completeableFutureTest();
    }

    public static void completeableFutureTest()  {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        System.out.println(("小明点餐"));

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(("厨师开始做菜"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(("厨师菜做好了"));
            return "菜已装盘";
        });

        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println(( "小明开始玩游戏"));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(("小明结束玩游戏"));
        });

        CompletableFuture<Void> completableFuture2 = completableFuture
            .thenAcceptBoth(completableFuture1,(a, b) -> System.out.println(( a + ", 小明开始吃饭,并点了饮料")))
            .thenApplyAsync((b) -> {
                System.out.println(("服务员拿饮料"));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "饮料好了";
            },executorService)
            .thenAcceptAsync((s) -> System.out.println((s + ",小明开始喝饮料")));

        completableFuture2.join();
    }
}
