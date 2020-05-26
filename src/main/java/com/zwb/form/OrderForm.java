package com.zwb.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Desc: 订单从前端传来的表单
 * @Author: zwb
 * @CreateTime: 2020/5/25 16:53
 **/
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "手机号必填")
    private String address;

    @NotEmpty(message = "买家openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;


}
