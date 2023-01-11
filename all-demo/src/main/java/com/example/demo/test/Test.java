package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试
 *
 * @author zaochun.zjw
 * @date 2022/11/2
 */
public class Test {

    public static void main(String[] args) {

        String str = "2023-01-10 16:06:32.811|椋庢帶缃戝叧|鍋ュ悍鍗℃祴璇晐鐩村\uE523娴嬭瘯|{\"appName\":\"alihealth-member-fund\",\"applyUserId\":2214174380273,\"bizScene\":\"鐩村\uE523娴嬭瘯\",\"bizType\":\"鍋ュ悍鍗℃祴璇�\",\"chainStack\":[\"com.alihealth.mf.fp.facade.CardWriteFacade#sendAsset#83\",\"com.alihealth.mf.fp.facade.CardWriteFacade#sendAsset#98\"],\"clientIp\":\"33.7.9.111\",\"env\":\"pre\",\"methodName\":\"sendAsset\",\"operateUserId\":0,\"recordDate\":\"2023-01-10 16:06:32\",\"request\":{\"com.alibaba.china.fp.client.request.asset.AssetSendReqDTO\":{\"extendInfos\":{},\"outBizId\":\"delaygift_16733379927622214174380273\",\"amount\":1,\"assetTemplateId\":\"880005001\",\"spreadRule\":{\"class\":\"com.alibaba.china.fp.client.request.asset.AssetsDynamicSpreadRule\",\"invalidDate\":1675929992762,\"effectiveDate\":1673337992762},\"class\":\"com.alibaba.china.fp.client.request.asset.AssetSendReqDTO\",\"userId\":2214174380273}},\"response\":{\"data\":{\"assetId\":13489564604100273},\"success\":true},\"serviceName\":\"com.alibaba.china.fp.client.service.asset.AssetSendService:1.0.0\"}";

        String[] split1 = str.split("\\|");
        JSONObject object = JSONObject.parseObject(split1[3]);
        System.out.println(object);
        System.out.println("test:" + object.get("operateUserId"));
        if(	object.get("operateUserId").equals(0)){
            System.out.println("test"+object.get("operateUserId"));
        }

        Arrays.asList();
        String test = "x";
        List<String> errorList = new ArrayList<>();
        errorList.add(test);

    }
}
