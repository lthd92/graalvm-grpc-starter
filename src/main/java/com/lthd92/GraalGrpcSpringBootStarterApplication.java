package com.lthd92;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class GraalGrpcSpringBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraalGrpcSpringBootStarterApplication.class, args);
	}

}
