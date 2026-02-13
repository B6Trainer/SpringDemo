package com.bala.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartSpringApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(StartSpringApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(StartSpringApplication.class, args);
		LOGGER.info("Spring application started successfully");



	}

}
