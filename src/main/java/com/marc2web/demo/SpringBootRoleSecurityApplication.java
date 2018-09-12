package com.marc2web.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication


public class SpringBootRoleSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRoleSecurityApplication.class, args);
		
		
	}
	

}
