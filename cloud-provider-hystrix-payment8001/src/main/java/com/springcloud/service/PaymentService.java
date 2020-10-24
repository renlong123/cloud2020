package com.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PaymentService {

    public String paymentInfoOK(Integer id){
        return "fast method";
    }

    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties ={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfoNotOK(Integer id){
       // int xx = 10/0;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "slow method O(∩_∩)O";
    }

    public String timeoutHandler(Integer id){
        return Thread.currentThread().getName()+"┭┮﹏┭┮！超时了";
    }

    //服务熔断
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled",value="true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value="60")
    }
    )
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id不能为负数，请稍后在试";
    }
}
