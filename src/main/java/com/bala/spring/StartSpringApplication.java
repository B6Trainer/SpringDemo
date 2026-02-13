package com.bala.spring;

import com.bala.spring.demodi.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StartSpringApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(StartSpringApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(StartSpringApplication.class, args);
		LOGGER.info("Spring application started successfully");

//		OrderService orderService=context.getBean(com.bala.spring.demodi.OrderService.class);
//		orderService.processOrder("Mobile", 2);

	}

}
