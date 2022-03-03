package com.shb.springcloud.controller;

import com.shb.springcloud.entities.CommonResult;
import com.shb.springcloud.entities.Payment;
import com.shb.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return paymentFeignService.get(id);
    }

    @GetMapping("/consumer/payment/paymentFeignTimeout")
    public String paymentFeignTimeout() throws InterruptedException {
        return paymentFeignService.paymentFeignTimeout();
    }
}
