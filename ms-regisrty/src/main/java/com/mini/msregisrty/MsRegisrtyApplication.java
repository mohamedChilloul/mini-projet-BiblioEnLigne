package com.mini.msregisrty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsRegisrtyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRegisrtyApplication.class, args);
	}

}
