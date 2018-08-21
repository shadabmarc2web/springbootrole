package com.marc2web.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.marc2web.demo.service")
//@EnableJpaRepositories("com.marc2web.demo")

public class SpringBootRoleSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRoleSecurityApplication.class, args);
	}
	

}
