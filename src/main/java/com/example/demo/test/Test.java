package com.example.demo.test;

/**
 * 测试
 *
 * @author zaochun.zjw
 * @date 2022/11/2
 */
public class Test {

    public static void main(String[] args) {
        String str = "WB01106110\n" +
            "WB01106119\n" +
            "WB01106109\n" +
            "WB01081758\n" +
            "WB01161603\n" +
            "WB01161605\n" +
            "WB578280\n" +
            "WB01180224\n" +
            "WB874455\n" +
            "WB01241922\n" +
            "WB01237704\n" +
            "WB01274402\n" +
            "WB873220\n" +
            "WB01232247\n" +
            "WB01377499\n" +
            "WB01401138\n" +
            "WB01408440\n" +
            "WB551394\n" +
            "WB603972\n" +
            "WB01377498\n" +
            "WB783186\n" +
            "WB01279741\n" +
            "WB872991\n" +
            "WB927961\n" +
            "WB01298662\n" +
            "WB01299534\n" +
            "WB01080104\n" +
            "WB01175175\n" +
            "WB01241324\n" +
            "WB01251097\n" +
            "WB942031\n" +
            "WB406324\n" +
            "WB01161265\n" +
            "WB871622\n" +
            "WB437961\n" +
            "WB547516\n" +
            "WB386314\n" +
            "WB01014409\n" +
            "WB510423\n" +
            "WB704792\n" +
            "WB658232";

        String replace = str.replace("\n", ",");

        System.out.println(replace);
    }
}
