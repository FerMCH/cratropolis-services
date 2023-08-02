package com.creatopolis.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@ComponentScan({"com.creatopolis.commons.model","com.creatopolis.usuarios.controller", "com.creatopolis.usuarios.services", "com.creatopolis.usuarios.serviceimp"})
@EnableJpaRepositories("com.creatopolis.usuarios.repository")
@EntityScan("com.creatopolis.commons.model")
@EnableTransactionManagement
public class CreatopolisUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreatopolisUsuariosApplication.class, args);
	}

}
