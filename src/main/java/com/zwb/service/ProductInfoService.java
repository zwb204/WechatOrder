package com.zwb.service;

import com.zwb.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 10:38
 **/
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    //查询所有在架的商品列表
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存

}
