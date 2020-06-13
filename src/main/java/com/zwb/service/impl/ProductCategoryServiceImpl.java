package com.zwb.service.impl;

import com.zwb.dataobject.ProductCategory;
import com.zwb.dataobject.dao.ProductCategoryDao;
import com.zwb.repository.ProductCategoryRepository;
import com.zwb.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/19 9:48
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

//    @Autowired
//    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer catagoryId) {
        return productCategoryRepository.findOne(catagoryId);
    }

//    @Override
//    public ProductCategory findOneByCategoryType(Integer catagoryCategory) {
//        return productCategoryDao.findOneByCategoryType(catagoryCategory);
//    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
