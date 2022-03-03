package com.shb.springcloud.service;

import com.shb.springcloud.entities.CommonResult;
import com.shb.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/paymentFeignTimeout")
    public String paymentFeignTimeout() throws InterruptedException;
}
