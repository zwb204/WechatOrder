package com.zwb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/5/28 9:49
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String myAppId;

    private String mpAppSecret;

}
