package com.ms.eurekaserver.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		// http://localhost:9094/hystrix.stream
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
}
