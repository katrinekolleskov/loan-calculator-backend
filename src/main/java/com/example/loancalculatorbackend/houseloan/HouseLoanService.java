package com.example.loancalculatorbackend.houseloan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public void addNewHouseLOan(HouseLoan houseLoan) {
        houseloanRepository.save(houseLoan);
    }

    public void deleteHouseLoan(Long houseLoanId) {
        System.out.println("houseloan: " + houseLoanId);
        boolean exists = houseloanRepository.existsById(houseLoanId);
        if (!exists) {
            throw new IllegalStateException (
                    "House loan with id " + houseLoanId + " does not exist."
            );
        }
        houseloanRepository.deleteById(houseLoanId);
    }

    @Transactional
    public void updateHouseLoan(Long houseLoanId, Double amount, Integer years) {
        HouseLoan houseLoan = houseloanRepository.findById(houseLoanId)
                .orElseThrow(() -> new IllegalStateException (
                    "House Loan with " + houseLoanId + " does not exist."));

        if (amount != null && amount > 0 && !houseLoan.getAmount().equals(amount)) {
            houseLoan.setAmount(amount);
        }

        if (years != null && years > 0 && houseLoan.getYears() != years) {
            houseLoan.setYears(years);
        }
    }
}
