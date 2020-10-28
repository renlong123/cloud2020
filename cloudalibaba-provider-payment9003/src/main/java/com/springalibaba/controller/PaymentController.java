package com.springalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long,String> hashMap = new HashMap<>();

    static{
        hashMap.put(1L,"fkdjlasfjklsdjfalsjfd89348heifhnkas");
        hashMap.put(2L,"fkdjlasfjkdfsdfsdfsjfd89348heifhnkas");
        hashMap.put(3L,"fkdjlasfsdfsdf sdfsa44tr348heifhnkas");
    }

    @GetMapping("/payment/{id}")
    public String paymentSQL(@PathVariable("id") Long id){
        return id+": "+hashMap.get(id)+ "from port:" + serverPort;
    }

}
