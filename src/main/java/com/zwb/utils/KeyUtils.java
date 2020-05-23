package com.zwb.utils;

import java.util.Random;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/23 21:59
 **/
public class KeyUtils {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
