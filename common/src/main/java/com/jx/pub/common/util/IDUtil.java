package com.jx.pub.common.util;

import java.util.UUID;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-01-30 18:39
 **/
public class IDUtil {

    /**
     * 获取32位的uuid
     * @return String
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-","");
    }
}
