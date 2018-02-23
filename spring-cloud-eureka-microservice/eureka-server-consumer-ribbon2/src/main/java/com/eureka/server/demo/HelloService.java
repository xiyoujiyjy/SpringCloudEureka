package com.eureka.server.demo;

import org.apache.log4j.Logger;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {

        Long start=System.currentTimeMillis();

        String result= restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
        Long end=System.currentTimeMillis();
        return  result;
    }

    public  String helloFallback(){
        return  "Error Circuit Breaker";
    }
}
