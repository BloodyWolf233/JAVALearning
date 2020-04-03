package com.heixin.user.mapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.heixin.user.mapper")
public class HeixinUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeixinUserApplication.class);
    }
}
