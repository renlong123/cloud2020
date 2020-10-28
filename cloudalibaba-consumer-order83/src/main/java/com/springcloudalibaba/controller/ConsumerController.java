package com.springcloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value(("${service-consumer-nacos.addr}"))
    private String TarUrl;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/nacos/{string}")
    public String paymentInfo(@PathVariable("string") String string){
        return restTemplate.getForObject(TarUrl+"/echo/"+string,String.class) + "call port: "+ serverPort;
    }
}
