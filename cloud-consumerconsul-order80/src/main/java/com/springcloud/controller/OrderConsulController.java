package com.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderConsulController {

    public static final String URL_ADDR = "http://cloud-provider-payment-consul";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(URL_ADDR+"/payment/consul",String.class);
        return result;
    }
}
