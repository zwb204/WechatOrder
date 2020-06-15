package com.zwb.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Desc: 商品详情
 * @Author: zwb
 * @CreateTime: 2020/5/19 13:45
 **/
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 7534886124030390049L;

    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;


}
