package com.ems.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.ems")
public class EmsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

}