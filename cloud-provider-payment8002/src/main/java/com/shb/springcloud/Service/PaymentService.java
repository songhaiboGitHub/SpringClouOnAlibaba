package com.shb.springcloud.Service;

import com.shb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author songhaibo
 * @create 2020-10-13 4:35 下午
 */
public interface PaymentService {
    public int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);
}
