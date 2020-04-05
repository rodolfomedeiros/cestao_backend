package com.devroods.cestao_backend;

import com.devroods.cestao_backend.services.NotaService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner run(NotaService notaService) throws Exception {
		return args -> {
			notaService.get();
		};
	}

}
