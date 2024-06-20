package com.example.demo.leetcode.base.model;

/**
 * 单例模式
 *
 * @author zaochun.zjw
 * @date 2024/3/13
 */
public class SingleModel {

    private static volatile SingleModel singleModel;

    private SingleModel() {
    }

    public static SingleModel getInstance() {

        if (singleModel == null) {
            synchronized (singleModel) {
                if (singleModel == null) {
                    singleModel = new SingleModel();
                }
            }
        }

        return singleModel;
    }
}
