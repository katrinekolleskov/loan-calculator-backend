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
         HouseLoan seilduk =  new HouseLoan(1L, 50000.0, 12);
         HouseLoan baerum = new HouseLoan (2L, 80000.0, 50);

         repository.saveAll(
                 List.of(seilduk, baerum)
         );
        };

    }
}
