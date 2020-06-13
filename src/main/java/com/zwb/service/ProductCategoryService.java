package com.zwb.service;

import com.zwb.dataobject.ProductCategory;

import java.util.List;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 9:43
 **/
public interface ProductCategoryService {
    ProductCategory findOne(Integer catagoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

//    ProductCategory findOneByCategoryType(Integer catagoryId);
}
