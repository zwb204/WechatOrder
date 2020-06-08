package com.zwb.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zwb.dataobject.ProductCategory;
import com.zwb.dataobject.ProductInfo;
import com.zwb.dto.OrderDTO;
import com.zwb.enums.ResultEnum;
import com.zwb.exception.SellException;
import com.zwb.form.ProductForm;
import com.zwb.service.OrderService;
import com.zwb.service.ProductCategoryService;
import com.zwb.service.ProductInfoService;
import com.zwb.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

/**卖家商品
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/3 16:28
 **/
@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 商品列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("currentSize", size);
        return new ModelAndView("product/list", map);
    }

    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String,Object> map){
        try {
            productInfoService.offSale(productId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.PRODUCT_OFF_SALE_SUCCESS.getMessage());
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("/common/success",map);
    }

    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                                Map<String,Object> map){
        try {
            productInfoService.onSale(productId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.PRODUCT_ON_SALE_SUCCESS.getMessage());
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("/common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                      Map<String,Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productInfoService.findOne(productId);
            map.put("productInfo",productInfo );
        }
        //查询所有的类目用于勾选
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("categoryList",productCategoryList);
        return new ModelAndView("product/index",map);
    }

    /**
     * 商品保存/更新
     * @param productForm
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm, BindingResult bindingResult,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }
        ProductInfo productInfo = new ProductInfo();
        try{
            // 如果productId为空，说明是新增商品
            if (!StringUtils.isEmpty(productForm.getProductId())) {
                productInfo = productInfoService.findOne(productForm.getProductId());
            } else {
                productForm.setProductId(KeyUtils.genUniqueKey());
            }
            BeanUtils.copyProperties(productForm,productInfo);
            productInfoService.save(productInfo);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.PRODUCT_SAVE_SUCCESS.getMessage());
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }
}
