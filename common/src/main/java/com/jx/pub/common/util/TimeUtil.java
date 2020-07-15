package com.jx.pub.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-01-30 18:39
 **/
public class TimeUtil {

    /**
     * 时间格式
     */
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /**
     * 日期格式
     */
    public static final String DATA_FORMAT = "yyyy-MM-dd";

    /**
     * 获取当前时间
     *
     * @return String
     */
    public static String getNowTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        return dateFormat.format(new Date());
    }

    /**
     * 获取当前日期
     *
     * @return String
     */
    public static String getNowData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATA_FORMAT);
        return dateFormat.format(new Date());
    }

    /**
     * 获取当前日期
     *
     * @return String
     */
    public static String getNow(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

    /**
     * 获取当天14点钟时间
     *
     * @return
     */
    public static String getRoomBeginTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 14:00:00");
        return dateFormat.format(new Date());
    }

    /**
     * 获取明天12点钟时间
     *
     * @return
     */
    public static String getRoomEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,1);
        Date time = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 12:00:00");
        return dateFormat.format(time);
    }
}
