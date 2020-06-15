package com.zwb.service;


/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/15 11:14
 **/
public interface SecKillService {

    String querySecKillProductInfo(String productId);

    void orderProductMockDiffUser(String productId);
}
