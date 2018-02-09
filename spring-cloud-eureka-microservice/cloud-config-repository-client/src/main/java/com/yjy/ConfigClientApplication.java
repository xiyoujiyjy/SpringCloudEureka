package com.yjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description :配置中心启动类
 */


@SpringBootApplication
//服务发现客户端注解，用于被发现
@EnableDiscoveryClient
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
        //1.配置中心服务器的地址
        //1.1 仓库中资源文件
        // http://localhost:8082/config-client.yml
        // http://localhost:8082/config-client/master
        //2.客户端访问API测试
        // http://localhost:8091/blog-info
        // http://localhost:8091/yjyapi/getRemoteGit

        //3. 测试三： 动态更新参数测试

        /*
        *
        *
        * 修改配置文件信息，上传git仓库。
          使用PostMan 或其他工具进行一次POST请求 API:http://localhost:8091/refresh
          再一次访问 http://localhost:8091/blog-info ，可以看到已在未重启的情况下，配置动态更新。
        *
        *
        *
        */
    }
}

