package com.springcloud.controller;

import com.springcloud.service.StreamSendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendController {

    @Resource
    private StreamSendService sendService;

    @GetMapping(value = "/sendmsg")
    public String sendMessage(){
        return sendService.send();
    }

}
