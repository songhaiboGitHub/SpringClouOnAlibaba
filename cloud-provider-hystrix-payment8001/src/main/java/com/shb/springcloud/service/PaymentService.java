package com.shb.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zzyy
 * @create 2020/3/6 22:23
 **/
@Service
public class PaymentService {
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
//        int age=10/0;
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "系统繁忙或运行报错请重试！线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler,id:" + id + "\t" +
                "o(╥﹏╥)o~";
    }

    /**
     * 服务熔断
     *
     * circuitBreaker.enabled：是否开启断路器
     * circuitBreaker.requestVolumeThreshold：请求次数
     * circuitBreaker.sleepWindowInMilliseconds：时间窗口期
     * circuitBreaker.errorThresholdPercentage：失败率
     * 一句话说明白：断路器打开的情况下，如果接口在10秒内有10次请求，
     * 但这10次请求其中有半数以上都失败了，那么断路器跳闸并熔断该方法
     * 此时正确的请求也不会调用到该方法了，而是直接走降级的方法
     * 过一段时间发现请求都正常了，断路器会慢慢的打开放行一些请求，直到完全打开！
     * 更多属性可以参考：HystrixPropertiesManager类
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            })
    public String paymentCircuitBreaker(Integer id) {

        if (id < 0) {
            throw new RuntimeException("id必须大于零");
        }
        return Thread.currentThread().getName() + " 查询成功，业务流水号是：" + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id必须大于零,id:" + id + "\t" + "o(╥﹏╥)o~";
    }


}


         