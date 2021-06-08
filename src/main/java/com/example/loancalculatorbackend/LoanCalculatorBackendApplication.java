package com.example.loancalculatorbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LoanCalculatorBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanCalculatorBackendApplication.class, args);
	}

	@GetMapping
	public String helloworld () {
		return "hello world";
	}
}

