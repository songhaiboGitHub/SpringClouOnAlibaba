package com.shb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author songhaibo
 * @create 2022-02-16 11:06 上午
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向zookeeper注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
