package com.yjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Description :

 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);

        /*
        * 配置文件访问地址
        * http://localhost:8082/config-client.yml
        * http://localhost:8082/config-client/master
        */
    }
}