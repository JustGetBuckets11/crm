package com.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.crm.mapper")
public class CrmSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrmSystemApplication.class,args);
    }
}
