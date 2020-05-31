package com.devroods.cestao_backend;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.devroods.cestao_backend.components.NfceFormInfoExtractComponent;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	@Autowired
	private NfceFormInfoExtractComponent nfceFormInfoExtractComponent;

	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}

	// @Bean
	// public CommandLineRunner runner() {
	// 	return args -> {
	// 		try {
	// 			JsonReader reader = new JsonReader(new FileReader(getClass().getResource("/keys.json").getFile()));
	// 			String[] strKeys = new Gson().fromJson(reader, String[].class);
	// 			for (String key : strKeys) {
	// 				System.out.println("Key: "+key+ "\nStatus: "+nfceFormInfoExtractComponent.fetch(key));
	// 			}
	// 		} catch (FileNotFoundException e) {
	// 			e.printStackTrace();
	// 		}
	// 	};
	// }

}
