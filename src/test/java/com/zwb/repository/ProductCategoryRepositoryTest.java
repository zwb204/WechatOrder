package com.zwb.repository;

import com.zwb.dataobject.ProductCategory;
import org.aspectj.apache.bcel.Repository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/4/27 23:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

//    @Test
//    public void findOneTest(){
//        ProductCategory productCategory = repository.findOne(1);
//        System.out.println(productCategory);
//    }
//
//    @Test
//    @Transactional  //使测试的数据不实际插入数据库，完全回滚
//    public void saveTest(){
//        ProductCategory productCategory = new ProductCategory("女生最爱",3);
//        ProductCategory result = repository.save(productCategory);
//        Assert.assertNotNull(result);
////        Assert.assertNotEquals(null,result);
//    }
//
//    @Test
//    public void updateTest(){
//        ProductCategory productCategory = repository.findOne(2);
//        productCategory.setCategoryName("男生最爱");
//        productCategory.setCategoryType(10);
//        repository.save(productCategory);
//    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}
