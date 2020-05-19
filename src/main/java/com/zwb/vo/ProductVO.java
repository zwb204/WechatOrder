package com.zwb.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Desc: 商品（包含类目）
 * @Author: zwb
 * @CreateTime: 2020/5/19 13:41
 **/
@Data
public class ProductVO {

    //类目名
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
