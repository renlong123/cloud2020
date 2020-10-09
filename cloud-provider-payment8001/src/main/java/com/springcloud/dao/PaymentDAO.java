package com.springcloud.dao;

import com.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//@Mapper
public interface PaymentDAO {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
