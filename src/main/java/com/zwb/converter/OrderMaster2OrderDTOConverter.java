package com.zwb.converter;

import com.zwb.dataobject.OrderMaster;
import com.zwb.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/24 21:44
 **/
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOList = orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
        return orderDTOList;
    }
}
