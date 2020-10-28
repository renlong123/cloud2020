package com.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloudalibaba.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SenController {

    @GetMapping("/testa")
    public String testA(){
        log.info(Thread.currentThread().getName()+"  A");
        return  "-------testA";
    }

    @GetMapping("/testb")
    public String testB(){
        log.info(Thread.currentThread().getName()+"  B");
        return  "-------testB";
    }

    @GetMapping("/testc")
    public String testC(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName()+"  C");
        return  "-------testC";
    }

    @GetMapping("/testd")
    public String testD(){
        log.info(Thread.currentThread().getName()+"  D");
        int age = 10/0;
        return  "-------testD";
    }

    @GetMapping("/testhot")
    @SentinelResource(value = "abc",blockHandler = "deal_hotkey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        int xx = 10/0;
        return "-----------------testHotKey";
    }

    public String deal_hotkey(String p1, String p2, BlockException blockException){
        return "new sentinel tips!";
    }

    @GetMapping("/ratelimit/blockhandler")
    @SentinelResource(value = "blockhandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "HandlerException2")
    public String testCustomerHandler(){
        return "-----------------testCustomerHandler---------------200:客户自定义";
    }
}
