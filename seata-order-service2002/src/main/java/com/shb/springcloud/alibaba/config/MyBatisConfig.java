package com.shb.springcloud.alibaba.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.shb.springcloud.alibaba.dao"})
public class MyBatisConfig {


}
