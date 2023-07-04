package com.example.demo.executor;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * guava的回调异步线程
 *
 * @author zaochun.zjw
 * @date 2023/7/3
 */
public class GuavaListenableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        GuavaListenableFuture future = new GuavaListenableFuture();
//        future.listenableFutureTest();listenableFutureTest();
        future.listenableFutureCallbackHellTest();
    }

    /**
     * 回调简单测试
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public void listenableFutureTest() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println(("小明点餐"));
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
        ListenableFuture<String> listenableFuture = listeningExecutorService.submit(() -> {
            System.out.println(("厨师开始炒菜"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(("厨师炒好菜"));
            return "饭菜好了";
        });
        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println((s + ",小明开始吃饭"));
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println((throwable.getMessage()));
            }
        }, executorService);

        System.out.println(("小明开始玩游戏"));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(("小明结束玩游戏"));

        listenableFuture.get();
        listeningExecutorService.shutdown();
        executorService.shutdown();
    }

    /**
     * 回调嵌套测试
     *
     * @throws InterruptedException 中断异常
     * @throws ExecutionException   执行异常
     */
    public void listenableFutureCallbackHellTest() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println(("小明点餐"));
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
        ListenableFuture<String> listenableFuture = listeningExecutorService.submit(() -> {
            System.out.println(("厨师开始做菜"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "菜已装盘";
        });
        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println((s + ",小明开始吃饭"));
                System.out.println(("小明点了个饮料"));
                ListenableFuture<String> listenableFuture1 = listeningExecutorService.submit(() -> {
                    System.out.println(("服务员拿饮料"));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "饮料好了";
                });
                Futures.addCallback(listenableFuture1, new FutureCallback<String>() {
                    @Override
                    public void onSuccess(@Nullable String s) {
                        System.out.println((s + ",小明开始喝饮料"));
                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                    }
                }, executorService);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println((throwable.getMessage()));
            }
        }, executorService);

        System.out.println(("小明开始玩游戏"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(("小明结束玩游戏"));

        listenableFuture.get();
        listeningExecutorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
