package com.zwb.form;

import com.zwb.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/4 17:49
 **/
@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus = ProductStatusEnum.UP.getCode();

    private Integer categoryType;
}
