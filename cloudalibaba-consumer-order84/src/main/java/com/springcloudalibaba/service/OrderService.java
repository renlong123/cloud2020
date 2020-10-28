package com.springcloudalibaba.service;

import com.springcloudalibaba.service.impl.OrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "nacos-payment-provider",fallback = OrderServiceImpl.class)
public interface OrderService {

    @GetMapping("/payment/{id}")
    public String paymentSQL(@PathVariable("id")Long id);

}
