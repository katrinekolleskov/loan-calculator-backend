package com.example.loancalculatorbackend;

import com.example.loancalculatorbackend.calculator.HouseLoan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class LoanCalculatorBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanCalculatorBackendApplication.class, args);
	}
}

