package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * diamond 动态配置
 *
 * @author zaochun
 * @date 2021-05-27
 */
@Slf4j
public class DynamicConfig {

    private static final Map<String, String> CONFIG = new ConcurrentHashMap<>(16);

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
     * @param def 默认值
     * @return 属性值
     */
    public static String getValue(String key, String def) {
        return StringUtils.defaultIfBlank(getValue(key), def);
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
     * 获取 long 类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return long 类型属性值
     */
    public static long getLongValue(String key, long def) {
        return NumberUtils.toLong(getValue(key), def);
    }

    /**
     * 获取 long 类型属性值
     *
     * @param key 属性键
     * @return long 类型属性值
     */
    public static long getLongValue(String key) {
        return NumberUtils.toLong(getValue(key), 0L);
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
     * 获取 布尔 类型属性值
     *
     * @param key 属性键
     * @return 布尔 类型属性值
     */
    public static boolean getBooleanValue(String key) {
        return getBooleanValue(key, false);
    }

    /**
     * 获取 JSON 类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return JSON 类型属性值
     */
    public static Optional<JSONObject> getJsonValue(String key, String def) {
        return Optional.ofNullable(JSONObject.parseObject(getValue(key, def)));
    }

    /**
     * 获取 JSON 类型属性值
     *
     * @param key 属性键
     * @return JSON 类型属性值
     */
    public static Optional<JSONObject> getJsonValue(String key) {
        return getJsonValue(key, null);
    }

    /**
     * 获取集合类型属性值
     *
     * @param key       属性键
     * @param def       默认值
     * @param converter 转换器
     * @param <T>       泛型
     * @return 集合类型属性值
     */
    public static <T> Set<T> getSetValue(String key, String def, Function<String, T> converter) {
        String value = getValue(key, StringUtils.trimToEmpty(def));

        return Stream.of(value.split(",")).filter(StringUtils::isNotBlank).map(String::trim).map(converter).collect(Collectors.toSet());
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return 集合类型属性值
     */
    public static Set<String> getSetValue(String key, String def) {
        return getSetValue(key, def, UnaryOperator.identity());
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @return 集合类型属性值
     */
    public static Set<String> getSetValue(String key) {
        return getSetValue(key, "");
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return 集合类型属性值
     */
    public static Set<Integer> getIntSetValue(String key, String def) {
        return getSetValue(key, def, NumberUtils::toInt);
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @return 集合类型属性值
     */
    public static Set<Integer> getIntSetValue(String key) {
        return getIntSetValue(key, "");
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return 集合类型属性值
     */
    public static Set<Long> getLongSetValue(String key, String def) {
        return getSetValue(key, def, NumberUtils::toLong);
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @return 集合类型属性值
     */
    public static Set<Long> getLongSetValue(String key) {
        return getLongSetValue(key, "");
    }

    /**
     * 获取集合类型属性值
     *
     * @param key       属性键
     * @param def       默认值
     * @param converter 转换器
     * @param <T>       泛型
     * @return 集合类型属性值
     */
    public static <T> List<T> getListValue(String key, String def, Function<String, T> converter) {
        String value = getValue(key, StringUtils.trimToEmpty(def));

        return Stream.of(value.split(",")).filter(StringUtils::isNotBlank).map(String::trim).map(converter).collect(Collectors.toList());
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return 集合类型属性值
     */
    public static List<String> getListValue(String key, String def) {
        return getListValue(key, def, UnaryOperator.identity());
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @return 集合类型属性值
     */
    public static List<String> getListValue(String key) {
        return getListValue(key, "");
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return 集合类型属性值
     */
    public static List<Integer> getIntListValue(String key, String def) {
        return getListValue(key, def, NumberUtils::toInt);
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @return 集合类型属性值
     */
    public static List<Integer> getIntListValue(String key) {
        return getIntListValue(key, "");
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @param def 默认值
     * @return 集合类型属性值
     */
    public static List<Long> getLongListValue(String key, String def) {
        return getListValue(key, def, NumberUtils::toLong);
    }

    /**
     * 获取集合类型属性值
     *
     * @param key 属性键
     * @return 集合类型属性值
     */
    public static List<Long> getLongListValue(String key) {
        return getLongListValue(key, "");
    }

    /**
     * 接收diamond配置
     *
     * @param config 配置
     */
    public void received(String config) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(config));

            for (Map.Entry<Object, Object> e : properties.entrySet()) {
                CONFIG.put(Objects.toString(e.getKey(), ""), Objects.toString(e.getValue(), ""));
            }
        } catch (IOException e) {
            log.error("parse receive dynamic config: {}", config, e);
        }
    }
}
