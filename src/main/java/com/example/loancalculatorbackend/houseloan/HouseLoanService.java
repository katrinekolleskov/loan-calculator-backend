package com.example.loancalculatorbackend.houseloan;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseLoanService {

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
