package com.foundationalspring.partone.configurationprts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigurationprtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationprtsApplication.class, args);

		// Pageable pageable = PageRequest.if(0, 2); //import SPRING DATA Dependency

	}

}
