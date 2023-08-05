package com.creatopolis.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@ComponentScan({"com.creatopolis.commons.model","com.creatopolis.auth.controller", "com.creatopolis.auth.services", "com.creatopolis.auth.servicesimp", "com.creatopolis.auth.config", "com.creatopolis.auth.dto", "com.creatopolis.auth.dto", "com.creatopolis.auth.jwt"})
@EnableJpaRepositories("com.creatopolis.auth.repository")
@EntityScan("com.creatopolis.commons.model")
@EnableTransactionManagement
public class CreatopolisAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreatopolisAuthApplication.class, args);
	}

}
