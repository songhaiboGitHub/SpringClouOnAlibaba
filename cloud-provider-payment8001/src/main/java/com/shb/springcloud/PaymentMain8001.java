package com.shb.springcloud;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songhaibo
 * @create 2020-10-13 11:06 上午
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }

    /**
     * 脱敏公共方法
     * @param no
     * @param pattern
     * @return
     */
    /*
    public static String encrypt(String no, String pattern) {
        if (StringUtils.isBlank(no) || StringUtils.isBlank(pattern) || no.contains("-") || !pattern.contains("*")) {
            return no;
        }
        //解析脱敏模式：即获取加密位数
        List<Integer> encrypt = new ArrayList<Integer>();
        char[] patternChar = pattern.toCharArray();
        for (int i = 0; i < patternChar.length; i++) {
            char patternByte = patternChar[i];
            if ('*' == patternByte) {
                encrypt.add(i);
            }
        }
        //将目标信息加密：即替换相应位置为*
        int length = no.length();
        StringBuffer sb = new StringBuffer(no);
        for (Integer index : encrypt) {
            if (index < length) {
                sb.setCharAt(index, '*');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("15232093386", "0000*"));
    }*/
}
