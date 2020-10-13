package com.shb.springcloud.Service.impl;

import com.shb.springcloud.Service.PaymentService;
import com.shb.springcloud.dao.PaymentDao;
import com.shb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author songhaibo
 * @create 2020-10-13 4:36 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
    @Override
    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.getPaymentById(id);
    }
}
