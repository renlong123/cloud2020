package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderZkController {

    public static final String URL_ADDR = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(URL_ADDR+"/payment/zk",String.class);
        return result;
    }

/*    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("开始添加");
        return restTemplate.postForObject(URL_ADDR+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("开始查询");
        return restTemplate.getForObject(URL_ADDR+"/payment/get/"+id,CommonResult.class);
    }*/
}
