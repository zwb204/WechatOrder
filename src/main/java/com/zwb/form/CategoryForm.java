package com.zwb.form;

import lombok.Data;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/8 16:20
 **/
@Data
public class CategoryForm {

    /**
     * 类目id
     */
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目类别
     */
    private Integer categoryType;
}
