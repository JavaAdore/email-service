package com.eltaieb.microservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
 
@EnableRabbit
@EnableAsync
@EnableDiscoveryClient
@SpringBootApplication
@PropertySource(value = {"classpath:email.properties","classpath:rabbit-mq.properties"})
public class EmailEngineApplication {

 
	public static void main(String[] args) {
		SpringApplication.run(EmailEngineApplication.class, args);
	}
	
 	 
}

