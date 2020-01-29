package com.jx.pub.common.util;

import java.util.UUID;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-28 13:28
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
