package com.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service-hystrix",fallback = PaymentFallbackServiceImpl.class)
public interface PaymentHytrixService {
    @GetMapping("payment/hystrix/ok/{id}")
    public String fastMethod(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/notok/{id}")
    public String slowMethod(@PathVariable("id") Integer id);


}
