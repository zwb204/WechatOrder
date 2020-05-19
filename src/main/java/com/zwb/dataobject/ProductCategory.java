package com.zwb.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Desc: 类目 product_category
 * @Author: zwb
 * @CreateTime: 2019/12/30 10:55
 **/
//@Table(name = "product_category")
@Entity   //数据库表映射为对象
@Data     //get和set等方法
@DynamicUpdate //动态更新时间
public class ProductCategory {

    /**
     * 类目id
     */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目类别
     */
    private Integer categoryType;

    private Date createTime;
    private Date updateTime;

    public ProductCategory(){

    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
