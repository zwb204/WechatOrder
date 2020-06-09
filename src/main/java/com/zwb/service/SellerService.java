package com.zwb.service;

import com.zwb.dataobject.SellerInfo;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/9 9:11
 **/
public interface SellerService {

    /**
     * 通过openid查询卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
