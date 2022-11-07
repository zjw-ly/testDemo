package com.example.demo.classloader;

/**
 * @author zaochun.zjw
 * @date 2022/10/19
 */
public class TestA {

    public static void main(String[] args) {
        TestA testA = new TestA();
        testA.hello();
    }

    public void hello() {
        System.out.println("TestA: " + this.getClass().getClassLoader());
        TestB testB = new TestB();
        testB.hello();
    }
}
