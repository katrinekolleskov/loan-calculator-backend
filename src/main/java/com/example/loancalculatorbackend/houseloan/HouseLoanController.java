package com.example.loancalculatorbackend.houseloan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/houseloan")
public class HouseLoanController {

    private final HouseLoanService houseLoanService;

    @Autowired
    public HouseLoanController(HouseLoanService houseLoanService) {
        this.houseLoanService = houseLoanService;
    }

    @GetMapping
    public List<HouseLoan> getHouseloan () {
        return houseLoanService.getHouseloan();
    }
}
