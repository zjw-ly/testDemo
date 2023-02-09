package com.example.demo.designmodle.single;

/**
 * 懒汉式单例
 *
 * @author zaochun.zjw
 * @date 2023/2/9
 */
public class LazySingle {

    //volatile保证原子性
    private static volatile LazySingle lazySingle = null;

    public static LazySingle getInstance() {
        //双重检验锁防止进入问题
        if (lazySingle == null) {
            synchronized (LazySingle.class) {
                if (lazySingle == null) {
                    lazySingle = new LazySingle();
                }
            }
        }

        return lazySingle;
    }
}
