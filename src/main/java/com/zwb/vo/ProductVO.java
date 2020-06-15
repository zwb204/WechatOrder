package com.zwb.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Desc: 商品（包含类目）
 * @Author: zwb
 * @CreateTime: 2020/5/19 13:41
 **/
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 7058810874953832992L;

    //类目名
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
