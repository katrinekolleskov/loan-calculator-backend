package com.example.loancalculatorbackend.houseloan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseLoanService {

    private final HouseLoanRepository houseloanRepository;

    @Autowired
    public HouseLoanService(HouseLoanRepository houseloanRepository) {
        this.houseloanRepository = houseloanRepository;
    }

    public List<HouseLoan> getHouseloan () {
        return houseloanRepository.findAll();

    }
}
