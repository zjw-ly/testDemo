package com.example.demo.freemarker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;

/**
 * freeMarker 按照模版自动生成
 *
 * @author zaochun.zjw
 * @date 2023/1/30
 */
@Data
public class FreeMarkerDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(FreeMarkerDemo.class);

    /** freemarker 配置，使用缓存 */
    private static final Configuration CONFIG = buildConfig();

    /** 参数上下文 */
    private JSONObject paramContext;

    /** 渲染模板 */
    private String tpl;

    /**
     * 提供一个静态方法供类使用
     *
     * @param parseObject 传入的数据
     * @param tpl         模版
     * @return 数据
     */
    public static FreeMarkerDemo build(JSONObject parseObject, String tpl) {
        return new FreeMarkerDemo(parseObject, tpl);
    }

    /**
     * 全参构造方法
     *
     * @param parseObject 传入的数据
     * @param tpl         模版
     */
    public FreeMarkerDemo(JSONObject parseObject, String tpl) {
        this.paramContext = parseObject;
        this.tpl = tpl;
    }

    /**
     * 创建 freemarker 配置
     *
     * @return freemarker 配置
     */
    public static Configuration buildConfig() {
        StringTemplateLoader templateLoader = new StringTemplateLoader();

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setTemplateLoader(templateLoader);
        configuration.setDefaultEncoding("UTF-8");
        // 数字输出不加逗号，即不使用千分位，参考 https://www.jianshu.com/p/1af1e8c230a9
        configuration.setNumberFormat("#");

        return configuration;
    }

    /**
     * 渲染
     *
     * @return 渲染结果
     */
    public String contextRender() {
        String md5 = DigestUtils.md5Hex(tpl);
        StringWriter writer = new StringWriter();

        try {
            Template template = new Template(md5, tpl, CONFIG);
            template.process(paramContext, writer);
        } catch (Throwable e) {
            LOGGER.error("{}|{}", "TPL_PARSE_FAIL", "模版渲染失败");
        }

        return writer.toString();
    }

    /**
     * 渲染
     *
     * @return 渲染结果
     */
    public JSONObject renderToJson() {

        try {
            return JSONObject.parseObject(contextRender(), JSONObject.class);
        } catch (Throwable e) {
            LOGGER.error("{}|{}", "TPL_PARSE_FAIL", "数据渲染失败");
        }

        return paramContext;
    }

    /**
     * 主方法 样式处理 -demo-  将数据按照 tpl模版的形式处理生成新的数据格式
     *
     * @param args xx
     */
    public static void main(String[] args) {
        String str = "<#assign request=com\\.alibaba\\.china\\.fp\\.client\\.request\\.asset\\.AssetSendReqDTO/>\n {\n \"userId\": ${request.userId}\n }";
        String data = "{" +
            "\"com.alibaba.china.fp.client.request.asset.AssetSendReqDTO\" : { \"userId\":318872\n " +
            "}" +
            "}";

        JSONObject test = FreeMarkerDemo.build(JSON.parseObject(data), str).renderToJson();
        System.out.println(test.get("userId"));

        String tplJson = "<#assign request=com\\.cardUserAvailableCardRequest/>\n" +
            "<#assign showCount=request.showCount/>\n" +
            "{\n" +
            "\"userId\": ${request.userId},\n" +
            "\"showCount\": ${showCount?c},\n" +
            "\"pageNo\": ${request.pageNo},\n" +
            "   <#if showCount>\n" +
            "\t   \"test\":\"true\",              \n" +
            "   <#else>\n" +
            "\t   \"test\":\"false\",              \n" +
            "   </#if>\n" +
            "\"pageSize\": ${request.pageSize}\n" +
            "}";
        JSONObject readerResultJson = FreeMarkerDemo.build(paramContext(), tplJson).renderToJson();
        System.out.println("s = " + readerResultJson);
    }

    public static JSONObject paramContext() {

        String json = "{\n" +
            "        \"com.cardUserAvailableCardRequest\":{\n" +
            "            \"showCount\":true,\n" +
            "            \"subBizTypeList\":[\n" +
            "                880452001,\n" +
            "                880005001,\n" +
            "                880005002\n" +
            "            ],\n" +
            "            \"pageNo\":2454545,\n" +
            "            \"pageSize\":10,\n" +
            "            \"extendInfo\":{},\n" +
            "            \"class\":\"com.taobao.card.domain.CardUserAvailableCardRequest\",\n" +
            "        \"cardBalanceDTOList\":[\n" +
            "            {\n" +
            "                \"freezeFee\":0,\n" +
            "                \"subfreezeFee\":0,\n" +
            "                \"subBizType\":880005001,\n" +
            "                \"bizType\":880005,\n" +
            "                \"subTotalFee\":15,\n" +
            "                \"balance\":0,\n" +
            "                \"subBalance\":0,\n" +
            "                \"totalFee\":1840,\n" +
            "                \"totalRefundFee\":1840,\n" +
            "                \"totalPreFreezingFee\":0,\n" +
            "                \"subRefundFee\":15\n" +
            "            },\n" +
            "            {\n" +
            "                \"freezeFee\":1,\n" +
            "                \"subfreezeFee\":0,\n" +
            "                \"subBizType\":880452001,\n" +
            "                \"bizType\":880452,\n" +
            "                \"subTotalFee\":0,\n" +
            "                \"balance\":406,\n" +
            "                \"subBalance\":0,\n" +
            "                \"totalFee\":471,\n" +
            "                \"totalRefundFee\":64,\n" +
            "                \"totalPreFreezingFee\":0,\n" +
            "                \"subRefundFee\":0\n" +
            "            }\n" +
            "        ],\n" +
            "        \"userId\":2212368794557\n" +
            "        },\n" +
            "        \"com.long\":2212368794557\n" +
            "    }";

        return JSON.parseObject(json);
    }
}
