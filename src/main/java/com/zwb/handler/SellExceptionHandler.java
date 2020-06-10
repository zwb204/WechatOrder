package com.zwb.handler;

import com.zwb.config.ProjectUrlConfig;
import com.zwb.exception.SellException;
import com.zwb.exception.SellerAuthorizeException;
import com.zwb.utils.ResultVOUtil;
import com.zwb.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.FORBIDDEN)  //修改返回状态码为403
    public ResultVO handlerSellException(SellException e) {
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
