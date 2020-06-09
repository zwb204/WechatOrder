package com.zwb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/9 11:53
 **/
@Component
@Data
@ConfigurationProperties(prefix = "projectUrl")
public class ProjectUrlConfig {

    /**
     * 微信公众账号授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开发平台授权url
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统
     */
    public String sell;
}
