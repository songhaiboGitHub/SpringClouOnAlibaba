package com.shb.springcloud.controller;

import com.shb.springcloud.Service.PaymentService;
import com.shb.springcloud.entities.CommonResult;
import com.shb.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author songhaibo
 * @create 2020-10-13 4:43 下午
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    //获取微服务的信息
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*********插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "success serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "fail serverPort:" + serverPort, result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("*********查询结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "success serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "fail serverPort:" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        //获取微服务的信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****element:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String lb() {
        return serverPort;
    }

    @GetMapping(value = "/payment/paymentFeignTimeout")
    public String paymentFeignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }
}
