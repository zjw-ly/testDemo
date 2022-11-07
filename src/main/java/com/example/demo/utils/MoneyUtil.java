package com.example.demo.utils;

import java.math.BigDecimal;

/**
 * @author ：hanhao.han
 * @date ：2022/8/26
 */
public class MoneyUtil {
    public MoneyUtil() {
    }

    public static String centToYuan(long cent, boolean stripTrailingZeros) {
        BigDecimal centDecimal = BigDecimal.valueOf(cent);
        BigDecimal yuanDecimal = centDecimal.movePointLeft(2);
        if (stripTrailingZeros) {
            yuanDecimal = yuanDecimal.stripTrailingZeros();
        }

        return yuanDecimal.toPlainString();
    }

    public static String centToYuan(long cent) {
        return centToYuan(cent, true);
    }

    public static Long yuanToCent(String yuan) {
        BigDecimal yuanDecimal = new BigDecimal(yuan);
        return yuanToCent(yuanDecimal);
    }

    public static Long yuanToCent(BigDecimal yuan) {
        BigDecimal centDecimal = yuan.movePointRight(2);
        return centDecimal.longValueExact();
    }
}
