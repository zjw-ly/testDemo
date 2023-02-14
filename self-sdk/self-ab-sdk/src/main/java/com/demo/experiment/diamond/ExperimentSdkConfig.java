package com.demo.experiment.diamond;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 配置
 *
 * @author zaochun.zjw
 * @date 2023/2/14
 */
public class ExperimentSdkConfig {


    private static final String DATA_ID = "alihealth-experiment-sdk.properties";

    private static final String DIAMOND_GROUP = "DEFAULT_GROUP";

    private static final Map<String, String> CONFIG = new ConcurrentHashMap<>(16);

    /**
     * 初始化当前业务身份
     */
    public void init() {
//
//        ExperimentSdkConfigListener listener = new ExperimentSdkConfigListener();
//        try {
//            Diamond.addListener(DATA_ID, DIAMOND_GROUP, listener);
//            listener.receiveConfigInfo(Diamond.getConfig(DATA_ID, DIAMOND_GROUP, 5000));
//        } catch (Throwable e) {
//            log.error("初始化实验SDK error:{0}", e);
//        }
    }

    /**
     * 获取 布尔 类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return 布尔 类型属性值
     */
    public static boolean getBooleanValue(String key, boolean def) {
        String value = getValue(key);

        return value == null ? def : Boolean.parseBoolean(value);
    }

    /**
     * 获取 int 类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return int 类型属性值
     */
    public static int getIntValue(String key, int def) {
        return NumberUtils.toInt(getValue(key), def);
    }

    /**
     * 获取 int 类型属性值
     *
     * @param key 属性键
     * @return int 类型属性值
     */
    public static int getIntValue(String key) {
        return getIntValue(key, 0);
    }

    /**
     * 获取属性值
     *
     * @param key 属性键
     * @return 属性值
     */
    public static String getValue(String key) {
        return CONFIG.get(key);
    }

    /**
     * 获取属性值
     *
     * @param key 属性键
     * @return 属性值
     */
    public static String getValue(String key, String def) {
        String value = getValue(key);

        return StringUtils.isBlank(value) ? def : value;
    }

}
