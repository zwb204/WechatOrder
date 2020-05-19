package com.zwb.service.impl;

import com.zwb.dataobject.ProductInfo;
import com.zwb.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 10:55
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,3);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("辣子鸡");
        productInfo.setProductPrice(new BigDecimal(30));
        productInfo.setProductStock(0);
        productInfo.setProductDescription("龙哥最爱");
        productInfo.setProductIcon("www");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }
}