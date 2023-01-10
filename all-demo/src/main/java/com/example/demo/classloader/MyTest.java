package com.example.demo.classloader;

import java.lang.reflect.Method;

/**
 * @author zaochun.zjw
 * @date 2022/10/19
 */
public class MyTest {


    public static void main(String[] args) throws Exception {
        //这里取AppClassLoader的父加载器也就是ExtClassLoader作为MyClassLoaderCustom的jdkClassLoader
        MyClassLoaderCustom myClassLoaderCustom = new MyClassLoaderCustom(Thread.currentThread().getContextClassLoader().getParent());

        Class testAClass = myClassLoaderCustom.loadClass("com.example.demo.util.TestA");
        Method mainMethod = testAClass.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null, new Object[]{args});
    }

}
