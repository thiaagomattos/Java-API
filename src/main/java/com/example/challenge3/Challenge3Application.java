package com.example.challenge3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class Challenge3Application {

	public static void main(String[] args) {
		SpringApplication.run(Challenge3Application.class, args);
	}

}
