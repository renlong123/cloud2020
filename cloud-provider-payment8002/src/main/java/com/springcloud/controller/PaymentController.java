package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果"+result);

        if(result > 0){
            return new CommonResult(200,"插入成功,端口为："+serverPort,result);
        }else{
            return new CommonResult(400,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        int age = 10/2;
        if(payment != null){
            return new CommonResult(200,"查询成功,端口为："+serverPort,payment);
        }else{
            return new CommonResult(400,"查询失败，对应id为"+id,null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        log.info("------into 8002----------");
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignService(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
