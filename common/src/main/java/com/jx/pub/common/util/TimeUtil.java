package com.jx.pub.common.util;

import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-28 14:10
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
     * @return String
     */
    public static String getNowTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        return dateFormat.format(new Date());
    }

    /**
     * 获取当前日期
     * @return String
     */
    public static String getNowData(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATA_FORMAT);
        return dateFormat.format(new Date());
    }

    /**
     * 获取当前日期
     * @return String
     */
    public static String getNow(String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }
}
