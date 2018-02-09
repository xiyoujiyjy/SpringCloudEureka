package com.yjy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description :配置中心启动类
 */
//服务发现客户端注解，用于被发现
@EnableDiscoveryClient
@SpringBootApplication
//开启配置中心服务器配置
@EnableConfigServer
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
        /*
        *
        * 配置文件访问地址
        * http://localhost:8082/config-client.yml
        * http://localhost:8082/config-client/master
        */

    }
}
