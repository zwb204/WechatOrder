package com.zwb.service.impl;

import com.zwb.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 9:52
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;
    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生专享",11);
        ProductCategory result = productCategoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}
