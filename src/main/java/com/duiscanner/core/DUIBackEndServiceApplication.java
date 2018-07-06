package com.duiscanner.core;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.demo.webExtractor.DUIDataExtractor;

@SpringBootApplication
@EnableScheduling
public class DUIBackEndServiceApplication {
	
//	@Autowired
//	static ConfigProperties config;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DUIBackEndServiceApplication.class, args);
	}
}
