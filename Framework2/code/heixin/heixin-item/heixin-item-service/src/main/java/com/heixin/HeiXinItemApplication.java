package com.heixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.heixin.item.mapper")
public class HeiXinItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeiXinItemApplication.class);
    }
}
