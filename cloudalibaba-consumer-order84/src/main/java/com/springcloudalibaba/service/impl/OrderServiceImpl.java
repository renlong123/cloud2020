package com.springcloudalibaba.service.impl;

import com.springcloudalibaba.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Override
    public String paymentSQL(Long id) {
        return "兜底方法全局 id: "+id;
    }
}
