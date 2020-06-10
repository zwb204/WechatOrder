package com.zwb.service.impl;

import com.zwb.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/10 10:28
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1590464208067639255");
        pushMessageService.orderStatus(orderDTO);
    }
}