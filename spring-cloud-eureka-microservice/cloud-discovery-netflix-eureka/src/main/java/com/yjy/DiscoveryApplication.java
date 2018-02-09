package com.yjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description : Eureka 服务发现server 启动类
 */
//springboot启动主程序注解
@SpringBootApplication
//服务发现服务端注解，设置以后将作为服务注册中心
@EnableEurekaServer
public class DiscoveryApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DiscoveryApplication.class);
    }
}
