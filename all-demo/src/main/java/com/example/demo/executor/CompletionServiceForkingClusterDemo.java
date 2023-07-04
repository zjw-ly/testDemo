package com.example.demo.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * CompletionService 集群模式
 *
 * @author zaochun.zjw
 * @date 2023/7/3
 */
public class CompletionServiceForkingClusterDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        executeTask();
    }

    private static void executeTask() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        List<Future<Integer>> futures = new ArrayList<>();
        //提交异步任务，并保存future到futures
        futures.add(completionService.submit(CompletionServiceForkingClusterDemo::getPriceByS1));
        futures.add(completionService.submit(CompletionServiceForkingClusterDemo::getPriceByS2));
        futures.add(completionService.submit(CompletionServiceForkingClusterDemo::getPriceByS3));

        // 获取最快返回的任务执行结果
        Integer r;
        try {
            // 只要有一个成功返回，则break
            for (int i = 0; i < 3; ++i) {
                r = completionService.take().get();
                //简单地通过判空来检查是否成功返回
                if (r != null) {
                    break;
                }
            }
        } finally {
            //取消所有任务
            for (Future<Integer> f : futures)
                f.cancel(true);

            executorService.shutdown();
        }
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
