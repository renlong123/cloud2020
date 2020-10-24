package com.springcloud.service.impl;

import com.springcloud.service.PaymentHytrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServiceImpl implements PaymentHytrixService {
    @Override
    public String fastMethod(Integer id) {
        return "payment service fallback OK";
    }

    @Override
    public String slowMethod(Integer id) {
        return "payment service fallback not OK";
    }
}
