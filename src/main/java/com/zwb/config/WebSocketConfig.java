package com.zwb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2020/6/10 11:36
 **/
@Component
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return  new ServerEndpointExporter();
    }
}
