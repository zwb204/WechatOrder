package com.zwb.enums;

import lombok.Getter;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 18:02
 **/
@Getter
public enum PayStatusEnum implements CodeEnum<Integer> {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;


    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
