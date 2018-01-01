package com.app.openlib.utils;

/**
 * Created by GetY on 2018/1/1.
 */

public class DataUtil {
    public static int pastInt(Object o,int defaultValue){
        if (o == null||"".equals(o.toString().trim())){
            return defaultValue;
        }else {
            try {
                return Integer.parseInt(o.toString());
            }catch (Exception e){
                return defaultValue;
            }
        }
    }
}
