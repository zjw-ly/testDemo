package com.example.demo.classloader;

/**
 * testB
 *
 * @author zaochun.zjw
 * @date 2022/10/19
 */
public class TestB {


    public void hello() {
        System.out.println("TestB: " + this.getClass().getClassLoader());
    }
}
