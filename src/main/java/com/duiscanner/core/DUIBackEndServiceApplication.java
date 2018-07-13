package com.duiscanner.core;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.demo.webExtractor.DUIDataExtractor;

@SpringBootApplication
@EnableScheduling
public class DUIBackEndServiceApplication extends SpringBootServletInitializer {
	
//	@Autowired
//	static ConfigProperties config;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DUIBackEndServiceApplication.class);
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DUIBackEndServiceApplication.class, args);
	}
}
