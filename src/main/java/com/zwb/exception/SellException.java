package com.zwb.exception;

import com.zwb.enums.ResultEnum;
import lombok.Getter;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/23 21:42
 **/
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
