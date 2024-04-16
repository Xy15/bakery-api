package com.example.bakeryApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.bakeryApi"})
@RestController
public class BakeryApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BakeryApiApplication.class, args);
	}

}
