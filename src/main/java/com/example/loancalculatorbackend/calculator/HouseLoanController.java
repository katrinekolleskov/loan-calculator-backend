package com.example.loancalculatorbackend.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/houseloan")
public class HouseLoanController {

    @GetMapping
    public List<HouseLoan> getHouseloan () {
        return List.of(
                new HouseLoan(
                        1L,
                        50000,
                        12
                )
        );
    }
}
