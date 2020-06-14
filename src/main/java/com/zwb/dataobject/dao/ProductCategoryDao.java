package com.zwb.dataobject.dao;

import com.zwb.dataobject.ProductCategory;
import com.zwb.dataobject.mapper.ProductCategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/11 16:00
 **/
//public class ProductCategoryDao {
//
//    @Autowired
//    private ProductCategoryMapper productCategoryMapper;
//
//
//    public int insertByMap(Map<String, Object> map) {
//        return productCategoryMapper.insertByMap(map);
//    }
//
//
//    public ProductCategory findOneByCategoryType(Integer categoryType) {
//        return productCategoryMapper.findByCategoryType(categoryType);
//    }
//}
