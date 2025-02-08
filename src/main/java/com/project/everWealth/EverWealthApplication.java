package com.project.everWealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.everWealth.healthStatus"})
public class EverWealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(EverWealthApplication.class, args);
	}

}
