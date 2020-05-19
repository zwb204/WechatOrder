package com.zwb.vo;

import lombok.Data;

/**
 * @Desc: http请求返回的最外层对象（vo是用来返回给前端的对象）
 * @Author: zwb
 * @CreateTime: 2020/5/19 13:23
 **/
@Data
public class ResultVO<T> {

    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //返回的具体内容
    private T data;
}
