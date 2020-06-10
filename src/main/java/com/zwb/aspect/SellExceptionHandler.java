package com.zwb.aspect;

import com.zwb.config.ProjectUrlConfig;
import com.zwb.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/10 9:20
 **/
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 拦截登录异常
     *
     * @return
     */
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerSellerAuthorizeException() {
        //http://127.0.0.1:8080/sell/wechat/qrAuthorize?returnUrl=127.0.0.1:8080/sell/seller/login
        return new ModelAndView("redirect:"
                .concat("")
                .concat("/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }
}
