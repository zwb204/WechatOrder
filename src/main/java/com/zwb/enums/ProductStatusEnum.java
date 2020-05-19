package com.zwb.enums;


import lombok.Getter;

/**
 * @Desc: 商品状态
 * @Author: zwb
 * @CreateTime: 2020/5/19 10:48
 **/
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;
    private String messger;

    ProductStatusEnum(Integer code,String messger){
        this.code = code;
        this.messger = messger;
    }

}
