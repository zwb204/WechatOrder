package com.zwb.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/9 10:25
 **/
@Component
public class WechatOpenConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public WxMpService wxOpenService() {
        WxMpService wxOpenService = new WxMpServiceImpl();
        wxOpenService.setWxMpConfigStorage(wxOpenConfigStorage());
        return wxOpenService;
    }

    @Bean
    public WxMpConfigStorage wxOpenConfigStorage() {
        WxMpDefaultConfigImpl wxOpenConfigStorage = new WxMpDefaultConfigImpl();
        wxOpenConfigStorage.setAppId(accountConfig.getOpenAppId());
        wxOpenConfigStorage.setSecret(accountConfig.getOpenAppSecret());
        return wxOpenConfigStorage;
    }
}
