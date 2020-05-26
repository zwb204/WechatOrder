package com.zwb.service;

import com.zwb.dto.OrderDTO;

/**
 * @Desc: 买家
 * @Author: zwb
 * @CreateTime: 2020/5/26 16:50
 **/
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancalOrder(String openid,String orderId);

}
