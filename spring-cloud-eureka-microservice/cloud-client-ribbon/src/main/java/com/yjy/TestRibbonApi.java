package com.yjy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
/**
 * @Description : 测试客户端负载均衡的接口API
 */
@RestController
@RequestMapping(value = "/test")
public class TestRibbonApi {
    /**
     * 注入RestTemplate
     */
    @Autowired
    RestTemplate restTemplate;


   @RequestMapping(value = "/name" ,method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hiError")
    public String testGetNameOfBlog(){
        String url="http://CLOUD-SERVICE-RIBBON/ribbon/name";
        return restTemplate.getForObject(url,String.class);
    }
    public String hiError() {
        String ret="{ \"code\":-1, \"msg\": \"服务故障，Hystrix 断路器打开\",\"issuccess\":false }";
        return ret;
    }
}
