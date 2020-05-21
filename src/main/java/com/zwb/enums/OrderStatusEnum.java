package com.zwb.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 17:57
 **/
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
