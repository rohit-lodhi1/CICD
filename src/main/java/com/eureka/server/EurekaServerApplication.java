package com.eureka.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

 public final static Logger logger  = LoggerFactory.getLogger(EurekaServerApplication.class);
	
	public static void main(String[] args) {
		logger.error("a gya nya build");
		SpringApplication.run(EurekaServerApplication.class, args);
		System.out.println("a gya nya build");
	}

}
