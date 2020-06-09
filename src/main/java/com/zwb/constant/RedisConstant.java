package com.zwb.constant;

/**
 * @Desc: Redis常量
 * @Author: zwb
 * @CreateTime: 2020/6/9 13:44
 **/
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";
    Integer EXPIRE = 7200; //过期时间：2小时
}
