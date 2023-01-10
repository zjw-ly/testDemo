package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 测试
 *
 * @author zaochun.zjw
 * @date 2022/11/2
 */
public class Test {

    public static void main(String[] args) {
        String  str = "{\"headers\":{},\"success\":true,\"class\":\"com.taobao.mtop.common.Result\",\"msgInfo\":\"短信黑名单手机号已经存在\",\"msgCode\":\"FAILBIZSMSBLACKLISTHASEXTIST\",\"httpStatusCode\":200}\n" +
            "\n";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject.get("success"));
        if ((boolean)jsonObject.get("success")) {
            System.out.println("取消成功");
        } else {
            System.out.println(String.format("取消失败,%s", jsonObject.get("msgInfo")));
        }
    }
}
