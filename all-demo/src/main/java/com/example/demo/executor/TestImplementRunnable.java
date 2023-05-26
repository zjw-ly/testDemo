package com.example.demo.executor;

/**
 * @author zaochun.zjw
 * @date 2023/5/18
 */
public class TestImplementRunnable {

    public static void main(String[] args) {

        Test test = new Test();
        test.run();
    }

    private static class Test implements Runnable{

        @Override
        public void run() {
            System.out.println("xx");
        }
    }
}
