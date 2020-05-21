package com.zwb.dataobject;

import com.zwb.enums.OrderStatusEnum;
import com.zwb.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Desc: 买家订单
 * @Author: zwb
 * @CreateTime: 2020/5/19 17:49
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    //买家微信openid
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态，默认新订单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态，默认未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

}
