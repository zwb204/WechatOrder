package com.zwb.dataobject.mapper;

import com.zwb.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/10 14:34
 **/
public interface ProductCategoryMapper {

    /**
     * 通过Map插入
     *
     * @param map
     * @return
     */
    @Insert("insert into product_category(category_name,category_type) " +
            "values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    /**
     * 通过对象更新
     *
     * @param productCategory
     * @return
     */
    @Insert("insert into product_category(category_name,category_type) " +
            "values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByProject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),      //数据库表字段映射到变量
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),      //数据库表字段映射到变量
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    /**
     * 通过字段更新
     *
     * @param categoryName
     * @param categoryType
     * @return
     */
    @Update("update product_category set category_name = #{categoryName} " +
            "where category_Type = #{categoryType}")
    // 多个参数需添加@Param注解
    int updateByCategoryType(@Param("categoryName") String categoryName, @Param("categoryType") Integer categoryType);

    /**
     * 通过对象更新
     *
     * @param productCategory
     * @return
     */
    @Update("update product_category set category_name = #{categoryName} " +
            "where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);
}

