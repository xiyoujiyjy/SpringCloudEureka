package com.yjy.eurekatomcatserviceproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
public class TestController {
    @Autowired
    private  DiscoveryClient client;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public  String hello(){

        ServiceInstance instance=client.getLocalServiceInstance();
        return  "test:"+instance.getPort();
    }
}
