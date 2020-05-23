package com.zwb.exception;

import com.zwb.enums.ResultEnum;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/23 21:42
 **/
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
