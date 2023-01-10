package com.example.demo.executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author zaochun.zjw
 * @date 2022/8/24
 */
public class ExecutorTest {

    public static void get() {
        ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig();

        ExecutorService asyncExecutor = threadPoolConfig.getAsyncExecutor();

        List<Future<String>> futureList = new ArrayList<>();
        System.err.println("任务开始：" + new Date(System.currentTimeMillis()));

        for (int j = 1; j <= 30; j++) {
            int finalJ = j;

            Future<String> future = asyncExecutor.submit(() -> {
                System.out.println("当前线程名称：" + Thread.currentThread().getName());
                if (finalJ % 2 == 0) {
                    int i = 0;
                    int res = 10 / i;
                    return "111";
                } else {
                    System.out.println("success");
                    return "tes";
                }
            });

            futureList.add(future);
        }
        System.err.println("任务结束：" + new Date(System.currentTimeMillis()));


        for (Future future : futureList) {
            try {
                future.get(1, TimeUnit.SECONDS);
            } catch (Throwable e) {
                System.out.println("打印异常｜" + e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        get();
    }
}
