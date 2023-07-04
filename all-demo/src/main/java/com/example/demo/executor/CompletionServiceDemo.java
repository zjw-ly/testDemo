package com.example.demo.executor;

import java.util.concurrent.*;

/**
 * CompletionService的Demo 底层原理：阻塞队列 + FutureTask 实现先获取再保存
 *
 * @author zaochun.zjw
 * @date 2023/6/28
 */
public class CompletionServiceDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletionServiceDemo completionServiceDemo = new CompletionServiceDemo();

        //按照调用结果生成的顺序执行后续服务
        completionServiceDemo.executeServiceOrder();
    }

//    3.1 CompletionService原理
//    内部通过 「阻塞队列+FutureTask」，实现了任务先完成可优先获取到，即结果按照完成先后顺序排序，
//    内部有一个先进先出的阻塞队列，用于保存已经执行完成的Future ，
//    通过调用它的 take 方法或 poll 方法可以获取到一个已经执行完成的Future，进而通过调用Future接口实现类的get方法获取最终的结果

    /**
     * 执行CompletionService服务 同时调用三个服务并按照调用成功的顺序 继续执行
     *
     * @throws InterruptedException 中断异常
     * @throws ExecutionException   执行异常
     */
    public void executeServiceOrder() throws InterruptedException, ExecutionException {
        //创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        //创建CompletionService
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        //异步向电商S1询价
        cs.submit(CompletionServiceDemo::getPriceByS1);
        //异步向电商S2询价
        cs.submit(CompletionServiceDemo::getPriceByS2);
        //异步向电商S3询价
        cs.submit(CompletionServiceDemo::getPriceByS3);

        for (int i = 0; i < 3; i++) {
            //take方法或者poll方法可以获取一个已经执行完成的一个Future；
            //若当前队列中没有结果 则等待直到出现队列数据为止。
            Integer integer = cs.take().get();

            executor.execute(() -> {
                try {
                    save(integer);
                } catch (InterruptedException e) {
                }
            });
        }

        executor.shutdown();
    }

    /**
     * 模拟 - 存库操作
     *
     * @param r 数字
     * @throws InterruptedException
     */
    private static void save(Integer r) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("保存询价结果:{}" + r);
    }

    /**
     * 模拟 - S1电商询价
     *
     * @return
     * @throws InterruptedException
     */
    private static Integer getPriceByS1() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5000);
        System.out.println("电商S1询价信息5000");
        return 5000;
    }

    /**
     * 模拟 - S2电商询价
     *
     * @return
     * @throws InterruptedException
     */
    private static Integer getPriceByS2() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(8000);
        System.out.println("电商S2询价信息8000");
        return 8000;
    }

    /**
     * 模拟 - S3电商询价
     *
     * @return
     * @throws InterruptedException
     */
    private static Integer getPriceByS3() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("电商S3询价信息3000");
        return 3000;
    }
}
