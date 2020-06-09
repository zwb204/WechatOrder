package com.zwb.repository;

import com.zwb.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/9 8:56
 **/
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String openid);
}
