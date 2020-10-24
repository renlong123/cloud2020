package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.PaymentHytrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "payment_global_method")
public class HystrixController {

    @Autowired
    private PaymentHytrixService paymentHytrixService;

    @GetMapping("payment/hystrix/ok/{id}")
    public String fastMethod(@PathVariable("id") Integer id){
        return paymentHytrixService.fastMethod(id);
    }

    @GetMapping("payment/hystrix/notok/{id}")
/*    @HystrixCommand(fallbackMethod = "PayTimeoutHandler",commandProperties ={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    @HystrixCommand
    public String slowMethod(@PathVariable("id") Integer id) {
        int i=10/0;
        return paymentHytrixService.slowMethod(id);
    }

    public String PayTimeoutHandler(Integer id){
        return Thread.currentThread().getName()+"┭┮﹏┭┮消费者80,服务提供方出错，请稍后再试";
    }

    public String payment_global_method(){
        return "全局异常信息处理，请稍后再试！";
    }

}
