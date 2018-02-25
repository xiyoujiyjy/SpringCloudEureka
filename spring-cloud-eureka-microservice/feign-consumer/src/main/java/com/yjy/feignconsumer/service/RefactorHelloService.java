package com.yjy.feignconsumer.service;

import com.yjy.service.*;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="HELLO-SERVICE")
public interface RefactorHelloService extends  HelloService{

}
