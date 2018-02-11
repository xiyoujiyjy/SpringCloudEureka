package com.yjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description :启动类，示范负载均衡服务器(添加断路器功能）
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class RibbonClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(RibbonClientApplication.class, args);
        /*
        * 一个注册中心、一个配置中心、两个相同配置的服务器、一台测试客户端负载均衡的测试服务器
        * */
    }
    /**
     * Spring提供的用于访问Rest服务的客户端
     * **@LoadBalanced** 注解加在RestTemplate上面，这个注解会自动构造LoadBalancerClient接口的实现类并注册到Spring容器中。
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}