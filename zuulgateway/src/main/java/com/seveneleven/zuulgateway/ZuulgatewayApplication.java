package com.seveneleven.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulgatewayApplication {
	
	@Bean
	public PreFilter perFilter() {
		return new PreFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulgatewayApplication.class, args);
	}

}
