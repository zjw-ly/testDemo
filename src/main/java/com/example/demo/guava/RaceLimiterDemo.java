package com.example.demo.guava;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 限流
 *
 * @author zaochun.zjw
 * @date 2022/8/26
 */
public class RaceLimiterDemo {

    public static void main(String[] args) throws InterruptedException {
        rateLimiterTest();

        //stopWatchElapsedTest();
    }

    /**
     * stopwatch测试类
     *
     * @throws InterruptedException 中断异常
     */
    private static void stopWatchElapsedTest() throws InterruptedException {
        Stopwatch stopWatch = Stopwatch.createStarted();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            long elapsed = stopWatch.elapsed(TimeUnit.MICROSECONDS);
            System.out.println(elapsed);
        }
    }

    /**
     * 限流工具类
     *
     * @throws InterruptedException 中断异常
     */
    private static void rateLimiterTest() throws InterruptedException {
        int threadNum = 10;
        ExecutorService threadPool = Executors.newFixedThreadPool(threadNum);
        RateLimiter limiter = RateLimiter.create(2);

        ThreadLocal<SimpleDateFormat> formatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("hh:mm:ss:SS"));
        for (int i = 0; i < threadNum; i++) {
            threadPool.execute(() -> {
                limiter.acquire();
                SimpleDateFormat simpleDateFormat = formatThreadLocal.get();
                String currentFormattedDate = simpleDateFormat.format(new Date());
                System.out.println("threadName : " + Thread.currentThread().getName() + " currentFormattedDate: " + currentFormattedDate);
            });
        }

        Thread.sleep(5 * 1000);
        threadPool.shutdown();
    }
}
