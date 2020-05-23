package com.zwb.enums;

import lombok.Getter;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/23 21:43
 **/
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCT_ERROR(11,"库存不足"),

    ;



    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
