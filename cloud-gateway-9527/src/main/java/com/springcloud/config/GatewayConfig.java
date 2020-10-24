package com.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customLocator(RouteLocatorBuilder builder){
        return builder.routes().route("path_haha",r->r.path("/guonei").uri("http://www.baidu.com/guonei")).build();
    }

}
