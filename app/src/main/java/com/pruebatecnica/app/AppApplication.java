package com.pruebatecnica.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pruebatecnica.app.repositorio.UsuarioRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UsuarioRepo.class)
public class AppApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppApplication.class, args);
	}

}
