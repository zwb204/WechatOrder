package com.zwb.service;

import com.zwb.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/21 16:05
 **/
public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);
    //查询单个订单
    OrderDTO findOne(String orderId);
    //查询订单列表，买家端，查询某个人
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    //取消订单
    OrderDTO cancle(OrderDTO orderDTO);
    //完结订单
    OrderDTO finish(OrderDTO orderDTO);
    //支付订单
    OrderDTO paid(OrderDTO orderDTO);

    //查询订单列表,卖家端，查询所有人
    Page<OrderDTO> findList(Pageable pageable);
}
