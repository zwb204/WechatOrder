package com.zwb.dto;

import lombok.Data;

/**
 * @Desc: 购物车
 * @Author: zwb
 * @CreateTime: 2020/5/23 22:24
 **/
@Data
public class CartDTO {

    //商品id
    private String productId;
    //商品数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
