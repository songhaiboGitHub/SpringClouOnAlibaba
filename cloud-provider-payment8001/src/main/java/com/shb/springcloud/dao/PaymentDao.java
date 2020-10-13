package com.shb.springcloud.dao;

import com.shb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author songhaibo
 * @create 2020-10-13 11:33 上午
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);
}
