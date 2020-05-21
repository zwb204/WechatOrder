package com.zwb.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 18:06
 **/
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    //商品单价
    private BigDecimal productPrice;

    //商品数量
    private Integer productQuantity;

    private String productIcon;


}
