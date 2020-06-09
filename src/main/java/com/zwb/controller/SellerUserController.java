package com.zwb.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zwb.config.ProjectUrlConfig;
import com.zwb.constant.CookieConstant;
import com.zwb.constant.RedisConstant;
import com.zwb.dataobject.SellerInfo;
import com.zwb.enums.ResultEnum;
import com.zwb.service.SellerService;
import com.zwb.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Desc: 卖家用户
 * @Author: zwb
 * @CreateTime: 2020/6/9 12:08
 **/
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse httpServletResponse,
                              Map<String, Object> map) {
        //1.openid去和数据库里的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        //2.设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;   //过期时间
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);
        //3.设置token至cookie
        CookieUtil.set(httpServletResponse, CookieConstant.TOKEN, token, expire);
        return new ModelAndView("redirect:" + "/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse,
                               Map<String, Object> map) {
        //1.从cookie里查询
        Cookie cookie = CookieUtil.get(httpServletRequest, CookieConstant.TOKEN);
        if (cookie != null) {
            //2.清除redis
            redisTemplate.opsForValue().getOperations()
                    .delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            //3.清除cookie
            CookieUtil.set(httpServletResponse, CookieConstant.TOKEN, null, 0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

}
