package com.zwb.dataobject.mapper;

import com.zwb.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/10 14:39
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("categoryName","老哥最喜欢");
        map.put("categoryType",101);
        int result = productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("老哥最不喜欢");
        productCategory.setCategoryType(102);
        int result = productCategoryMapper.insertByProject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory result = productCategoryMapper.findByCategoryType(102);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> result = productCategoryMapper.findByCategoryName("老哥最喜欢");
        Assert.assertNotNull(result);
    }

    @Test
    public void updateByCategoryType() {
        int result = productCategoryMapper.updateByCategoryType("蒲良老哥最喜欢",101);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("老哥最喜欢");
        productCategory.setCategoryType(101);
        int result = productCategoryMapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteByCategoryType(){
        int result = productCategoryMapper.deleteByCategoryType(102);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory result = productCategoryMapper.selectByCategoryType(101);
        Assert.assertNotNull(result);
    }
}