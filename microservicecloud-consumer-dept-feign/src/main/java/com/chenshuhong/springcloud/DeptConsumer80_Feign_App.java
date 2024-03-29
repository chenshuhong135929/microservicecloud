package com.chenshuhong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ZeroV on 2018/11/6.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.chenshuhong.springcloud"})
@ComponentScan("com.chenshuhong.springcloud")
public class DeptConsumer80_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }
}
