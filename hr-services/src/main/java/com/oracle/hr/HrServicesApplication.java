package com.oracle.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HrServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrServicesApplication.class, args);
	}

}
