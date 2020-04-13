package com.leilei.orderserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderServer8003 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServer8003.class,args);
    }
}
