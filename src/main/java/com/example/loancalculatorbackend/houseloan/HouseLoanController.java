package com.example.loancalculatorbackend.houseloan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewHouseLoan (@RequestBody HouseLoan houseLoan) {
        houseLoanService.addNewHouseLOan(houseLoan);
    }

    // Don't think this is necessary for the task at hand, but I figured it was well enough to add (for scaling!).
    @DeleteMapping(path = "{houseLoanId}")
    public void deleteHouseLoan(@PathVariable("houseLoanId") Long houseLoanId) {
        houseLoanService.deleteHouseLoan(houseLoanId);
    }

    // Don't think this is necessary for the task at hand, but I figured it was well enough to add (for scaling!).
    @PutMapping(path = "{houseLoanId}")
    public void updateHouseLoan(
            @PathVariable("houseLoanId") Long houseLoanId,
            @RequestParam(required  = false) Double amount,
            @RequestParam(required = false) Integer years) {
        houseLoanService.updateHouseLoan(houseLoanId, amount, years);
    }
}
