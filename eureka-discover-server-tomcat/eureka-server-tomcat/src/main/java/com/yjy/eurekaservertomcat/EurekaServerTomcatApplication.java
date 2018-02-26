package com.yjy.eurekaservertomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerTomcatApplication  extends  SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EurekaServerTomcatApplication.class);
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServerTomcatApplication.class).web(true).run(args);
	}
}
