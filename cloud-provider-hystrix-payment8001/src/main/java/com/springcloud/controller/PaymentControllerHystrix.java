package com.springcloud.controller;

import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@Slf4j
public class PaymentControllerHystrix {

    @Autowired
    private PaymentService service;

    @GetMapping("payment/hystrix/ok/{id}")
    public String fastMethod(Integer id){
        return service.paymentInfoOK(id);
    }

    @GetMapping("payment/hystrix/notok/{id}")
    public String slowMethod(Integer id){
        return service.paymentInfoNotOK(id);
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitService(@PathVariable("id")Integer id){
        String result = service.paymentCircuitBreaker(id);
        log.info("******result:"+result);
        return result;
    }
}
