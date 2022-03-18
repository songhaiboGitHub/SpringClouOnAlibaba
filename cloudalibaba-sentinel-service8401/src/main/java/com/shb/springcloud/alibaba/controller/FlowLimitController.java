package com.shb.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "lt" + " .... testB");
        return "------testB";
    }

   /* RT 测试
   @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");

        return "------testD";
    }*/

    /*
按照上述配置,
单独访问一次，必然来一次报错一 次(int age = 10/0), 调一-次错一次;
●异常比例( DEGRADE_ GRADE_ EXCEPTION_ RATIO): 当资源的每秒请求量>= 5,并且每秒异常总数占通
过量的比值超过阈值( DegradeRule中的count )之后，资源进入降级状态，即在接下的时间窗口
( DegradeRule中的timevindow, 以s为单位)之内，对这个方法的调用都会自动地返回。异常
比率的阈值范围是[e.0, 1.0].代表0% - 100%。
开启jmeter后，直接高并发发送请求,多次调用达到我们的配置条件了。
断路器开启(保险丝跳闸)，微服务不可用了，不再报错error而是服务降级了。*/
    @GetMapping("/testD")
    public String testD() {
        log.info("testD 测试 异常比例");
        int age = 10 / 0;
        return "------testD";
    }


}

