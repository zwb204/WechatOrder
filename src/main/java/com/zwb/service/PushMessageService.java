package com.zwb.service;

import com.zwb.dto.OrderDTO;

/**
 * @Desc: 微信消息推送
 * @Author: zwb
 * @CreateTime: 2020/6/10 10:10
 **/
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
