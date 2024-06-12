package com.example.demo.leetcode.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 *
 * @author ：hanhao.han
 * @date ：2022/10/21
 */
public class DateUtils {

    /**
     * 判断两个时间范围是否有交集
     *
     * @param dynaStartTime  比较时间段开始时间
     * @param dynaEndTime    比较时间段结束时间
     * @param fixedStartTime 参考时间段开始时间
     * @param fixedEndTime   参考时间段结束时间
     * @return
     */
    public static boolean checkTimesHasOverlap(Date dynaStartTime, Date dynaEndTime, Date fixedStartTime, Date fixedEndTime) {
        if (dynaStartTime.getTime() <= fixedStartTime.getTime() && dynaEndTime.getTime() > fixedStartTime.getTime()) {
            return true;
        } else if (dynaStartTime.getTime() >= fixedStartTime.getTime() && dynaStartTime.getTime() < fixedEndTime.getTime()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 获取时间差值
     *
     * @param pastTime
     * @return
     */
    public static String getDateDiff(Date pastTime) {
        return getDateDiff(pastTime.getTime());
    }

    /**
     * 获取时间差值
     *
     * @param pastTime
     * @return
     */
    public static String getDateDiff(long pastTime) {
        return getDateDiff(pastTime, new Date().getTime());
    }

    /**
     * 获取时间差值
     *
     * @param pastTime
     * @param afterTime
     * @return
     */
    public static String getDateDiff(Date pastTime, Date afterTime) {
        return getDateDiff(pastTime.getTime(), afterTime.getTime());
    }

    /**
     * 获取时间差值
     *
     * @param pastTime
     * @param afterTime
     * @return
     */
    public static String getDateDiff(long pastTime, long afterTime) {
        long diff = afterTime - pastTime;
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;

        return String.format("%s:%s:%s", diffHours == 0 ? "00" : diffHours, diffMinutes == 0 ? "00" : diffMinutes, diffSeconds == 0 ? "00" : diffSeconds);
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     */
    public static int daysBetween(Date smdate, Date bdate) {
        // 创建两个Calendar对象
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        // 将Date对象设置到对应的Calendar对象中
        calendar1.setTime(bdate);
        calendar2.setTime(smdate);

        // 获取两个Calendar对象的时间戳
        long timeInMillis1 = calendar1.getTimeInMillis();
        long timeInMillis2 = calendar2.getTimeInMillis();

        // 计算时间戳差值，转换为天数差值
        long diffInMillis = Math.abs(timeInMillis1 - timeInMillis2);
        return Integer.parseInt(String.valueOf(diffInMillis / (24 * 60 * 60 * 1000) + 1));
    }

    public static void main(String[] args) throws ParseException {
//        String date1Start = "2022-09-01 00:00:00";
//        String date1End = "2022-09-30 00:00:00";
//        String date2Start = "2022-12-01 00:00:00";
//        String date2End = "2022-12-30 00:00:00";

        String date1Start = "2022-11-01 00:00:00";
        String date1End = "2022-12-02 00:00:00";
        String date2Start = "2022-12-01 00:00:00";
        String date2End = "2022-12-30 00:00:00";

        System.out.println(checkTimesHasOverlap(getDate(date1Start), getDate(date1End), getDate(date2Start), getDate(date2End)));
    }

    public static Date getDate(String s) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
    }
}
