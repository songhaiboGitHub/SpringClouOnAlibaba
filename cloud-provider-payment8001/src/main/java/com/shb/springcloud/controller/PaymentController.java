package com.shb.springcloud.controller;

import com.shb.springcloud.Service.PaymentService;
import com.shb.springcloud.entities.CommonResult;
import com.shb.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author songhaibo
 * @create 2020-10-13 4:43 下午
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("*********插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "success", result);
        } else {
            return new CommonResult(444, "fail", result);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("*********查询结果：" + payment);

        if (payment !=null) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(444, "fail", null);
        }
    }
}
