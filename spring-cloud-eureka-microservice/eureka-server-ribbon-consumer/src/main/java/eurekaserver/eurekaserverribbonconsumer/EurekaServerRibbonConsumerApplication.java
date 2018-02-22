package eurekaserver.eurekaserverribbonconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServerRibbonConsumerApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return  new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerRibbonConsumerApplication.class, args);
		//服务注册类配置
		org.springframework.cloud.netflix.eureka.EurekaClientConfigBean clientConfigBean;
		//服务实例类配置
		org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean instanceConfigBean;
	}
}
