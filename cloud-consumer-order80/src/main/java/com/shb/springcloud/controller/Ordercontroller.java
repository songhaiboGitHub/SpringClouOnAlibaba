package com.shb.springcloud.controller;

import com.shb.springcloud.entities.CommonResult;
import com.shb.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author songhaibo
 * @create 2020-10-14 10:14 上午
 */
@RestController
@Slf4j
public class Ordercontroller {
    public static final String PATMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PATMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PATMENT_URL + "/payment/get/"+id, CommonResult.class);
    }
}
