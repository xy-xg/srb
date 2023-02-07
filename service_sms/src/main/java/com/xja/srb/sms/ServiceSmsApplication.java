package com.xja.srb.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author xiaoYan
 * @Data 2023/1/6 19:34
 * 时间不早了  注意休息
 */

@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.xja"})
public class ServiceSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSmsApplication.class, args);
    }
}