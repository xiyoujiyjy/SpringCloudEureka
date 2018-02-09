package com.yjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Administrator on 2017/12/17.
 * 网关启动入口
 * **@EnableZuulProxy** 注解说明：@EnableZuulProxy简单理解为@EnableZuulServer的增强版，
 * 当Zuul与Eureka、Ribbon等组件配合使用时，我们使用@EnableZuulProxy。
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        /*
        访问API测试
我们在cloud-service子项目中，之前已经做过一个测试的API,
子微服务	    地址	                路径	请求方式
cloud-service	http://localhost:8071	/ribbon/name	GET
在没有网关之前，我们外部如果想要调用服务的花，就可以通过微服务自身的地址访问。但是有了API网关之后，我们可以将我们的服务地址对外暴露出去。

子微服务	    地址	                路径	    请求方式
cloud-service	http://localhost:8080	/ribbon/name	GET

访问地址： 网关地址/服务名/访问地址/
http://localhost:8080/cloud-service/ribbon/name

        */
    }
}