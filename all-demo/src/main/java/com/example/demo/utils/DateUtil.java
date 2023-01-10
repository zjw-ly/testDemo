package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具
 *
 * @author ：hanhao.han
 * @date ：2022/10/21
 */
public class DateUtil {

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

    public static void main(String[] args) throws ParseException {
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
