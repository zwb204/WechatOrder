package com.zwb.repository;

import com.zwb.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 18:18
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
