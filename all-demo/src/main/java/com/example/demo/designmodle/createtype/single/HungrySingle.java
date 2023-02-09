package com.example.demo.designmodle.createtype.single;

/**
 * 饿汉式例模式
 *
 * @author zaochun.zjw
 * @date 2023/2/9
 */
public class HungrySingle {

    //构造器私有化 保证外部无法访问
    private HungrySingle() {
    }

    private static final HungrySingle single = new HungrySingle();

    public static HungrySingle getInstance() {
        return single;
    }
}
