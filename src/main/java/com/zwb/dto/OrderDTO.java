package com.zwb.dto;

import com.zwb.dataobject.OrderDetail;
import com.zwb.enums.OrderStatusEnum;
import com.zwb.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/21 16:11
 **/
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    //买家微信openid
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态，默认新订单
    private Integer orderStatus;

    //支付状态，默认未支付
    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
