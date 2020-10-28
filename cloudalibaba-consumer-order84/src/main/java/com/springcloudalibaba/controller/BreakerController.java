package com.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.springcloudalibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class BreakerController {

/*    private static final String PAYMENT_URL = "http://nacos-payment-provider" ;
*//*
    @Autowired
    private RestTemplate restTemplate;*//*

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback")
    public String fallback(@PathVariable("id")Long id){
        String object = restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, String.class);
        if(id == 4){
            throw new IllegalArgumentException("输入参数异常！");
        }else if(object==null||object.length()< 40){
            throw new NullPointerException("没有查找到对应记录");
        }
        return object;
    }

    public String handlerFallback(@PathVariable("id")Long id){
        return "统一异常处理,id:   "+id;
    }*/

    @Resource
    private OrderService service;

    @GetMapping("/consumer/fallback/{id}")
    public String testFallback(@PathVariable("id")Long id){
        return service.paymentSQL(id);
    }
}
