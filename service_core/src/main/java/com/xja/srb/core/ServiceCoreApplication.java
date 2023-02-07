package com.xja.srb.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author xiaoYan
 * @Data 2023/1/3 18:15
 * 时间不早了  注意休息
 */
@SpringBootApplication
@ComponentScan({"com.xja.srb","com.xja.common"})
public class ServiceCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCoreApplication.class,args);
    }
}
