package com.example.dev;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.dev.repo.CountryRepository;


@SpringBootApplication
public class HealthCheckApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HealthCheckApplication.class, args);
	}

	@Autowired
	private CountryRepository countryRepository;
	@Override
	public void run(String... args) throws Exception {
		
	

}
}
