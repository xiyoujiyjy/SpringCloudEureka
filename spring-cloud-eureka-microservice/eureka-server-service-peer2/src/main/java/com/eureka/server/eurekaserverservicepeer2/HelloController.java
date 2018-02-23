package com.eureka.server.eurekaserverservicepeer2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public  String hello() throws InterruptedException {
        ServiceInstance instance=client.getLocalServiceInstance();
        //
        int sleepTime=new Random().nextInt(3000);
       // Thread.sleep(sleepTime);

        return "Hello World 9082:"+instance.getPort();
    }

}
