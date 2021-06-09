package com.example.loancalculatorbackend.houseloan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HouseLoanConfig {

    @Bean
    CommandLineRunner commandLineRunner(HouseLoanRepository repository) {
        return args -> {
         HouseLoan seilduk =  new HouseLoan(50000.0, 2);
         HouseLoan baerum = new HouseLoan (80000.0, 1);

         repository.saveAll(
                 List.of(seilduk, baerum)
         );
        };

    }
}
