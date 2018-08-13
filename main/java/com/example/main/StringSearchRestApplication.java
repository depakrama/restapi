package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {"com.example"})
public class StringSearchRestApplication {
	
		public static void main(String[] args) {
		SpringApplication.run(StringSearchRestApplication.class, args);
		
	}
}
