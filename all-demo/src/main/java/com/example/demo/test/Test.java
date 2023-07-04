package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.schedulerx.shade.org.apache.commons.collections.list.AbstractLinkedList;
import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * 测试
 *
 * @author zaochun.zjw
 * @date 2022/11/2
 */
public class Test {

    public static void main(String[] args) {

        String str = "**用户健康卡已延期记录:**  \n\n**——————————————** \n\n订单号: 默认直塞赠金场景 \n\n 过期金额: 0.01元 \n\n  赠金类型: 买返赠金 \n\n 是否已延期: 已延期 \n\n  延期时间: 2023-06-26 17:12:58 \n\n**——————————————** \n\n订单号: 默认直塞赠金场景 \n\n 过期金额: 0.01元 \n\n  赠金类型: 买返赠金 \n\n 是否已延期: 已延期 \n\n  延期时间: 2023-06-26 17:12:58 \n\n**——————————————** \n\n订单号: 默认直塞赠金场景 \n\n 过期金额: 0.01元 \n\n  赠金类型: 买返赠金 \n\n 是否已延期: 已延期 \n\n  延期时间: 2023-06-26 17:12:58 \n\n**——————————————** \n\n订单号: 默认直塞赠金场景 \n\n 过期金额: 0.01元 \n\n  赠金类型: 买返赠金 \n\n 是否已延期: 已延期 \n\n  延期时间: 2023-06-26 17:12:58 \n\n**——————————————** \n\n订单号: 默认直塞赠金场景 \n\n 过期金额: 0.01元 \n\n  赠金类型: 活动赠金 \n\n 是否已延期: 已延期 \n\n  延期时间: 2023-06-26 17:12:58 \n\n**——————————————** \n\n订单号: 赠送 \n\n 过期金额: 0.02元 \n\n  赠金类型: 活动赠金 \n\n 是否已延期: 已延期 \n\n  延期时间: 2023-06-26 17:12:58 \n\n**——————————————** \n\n订单号: 默认直塞赠金场景 \n\n 过期金额: 0.01元 \n\n  赠金类型: 活动赠金 \n\n 是否已延期: 已延期 \n\n  延期时间: 2023-06-26 17:12:58 \n\n**——————————————** \n\n订单号: 3269777763105387302 \n\n 过期金额: 0.02元 \n\n  赠金类型: 充值赠金 \n\n 是否已延期: 已延期 \n\n  延期时间: 2023-06-26 17:12:58 \n\n";

        System.out.println(str);
        //System.out.println("**用户健康卡赠金延期明细: **  \n\n **需要延期健康卡赠金的总金额:0.07元** \n\n **需要延期的买返总过期金额:0元** \n\n **需要延期的直塞总过期金额:0.04元** \n\n **需要延期的充增总过期金额:0.03元** \n\n**——————————————** \n\n订单号: 默认赠金场景 \n\n 过期金额: 0.01元 \n\n  赠金类型: DIRECT \n\n**——————————————** \n\n订单号: 赠送 \n\n 过期金额: 0.02元 \n\n  赠金类型: DIRECT \n\n**——————————————** \n\n订单号: 默认赠金场景 \n\n 过期金额: 0.01元 \n\n  赠金类型: DIRECT \n\n**——————————————** \n\n订单号: 3198739753396387302 \n\n 过期金额: 0.01元 \n\n  赠金类型: RECHARGE \n\n**——————————————** \n\n订单号: 3269777763105387302 \n\n 过期金额: 0.02元 \n\n  赠金类型: RECHARGE \n\n");
    }
}
