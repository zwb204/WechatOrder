package com.zwb.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zwb.enums.ProductStatusEnum;
import com.zwb.utils.EnumUtil;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Desc: 商品信息
 * @Author: zwb
 * @CreateTime: 2020/5/19 10:14
 **/
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {

    // Redis缓存存储的对象需要实现序列化
    private static final long serialVersionUID = -7786068976950700831L;

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}
