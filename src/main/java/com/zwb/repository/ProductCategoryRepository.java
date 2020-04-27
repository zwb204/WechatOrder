package com.zwb.repository;

import com.zwb.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/12/30 11:01
 * 包名repository就是dto
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
