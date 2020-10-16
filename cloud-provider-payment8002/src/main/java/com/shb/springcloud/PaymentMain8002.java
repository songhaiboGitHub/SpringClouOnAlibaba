package com.shb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author songhaibo
 * @create 2020-10-13 11:06 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //获取微服务的信息
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
