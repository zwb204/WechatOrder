package com.zwb.service.impl;

import com.zwb.dataobject.SellerInfo;
import com.zwb.repository.SellerInfoRepository;
import com.zwb.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/9 9:15
 **/
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
