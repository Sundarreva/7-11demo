package com.seveneleven.employeeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class EmployeeServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeServiceApplication.class, args);

		// change on branch in local device check
		// change on master branch in local device
	}

}
