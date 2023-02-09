package com.gk.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
/*
 * On Spring Boot 3.0.0 and Java 17, @EnableEurekaClient is deprecated no need
 * to annotate at spring boot main application it is fine if we add the
 * spring-cloud-starter-netflix-eureka-client dependency in pom and if we have
 * the application name in yml or properties file it will be registered to
 * Eureka Server.
 */
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
