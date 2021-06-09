package com.example.loancalculatorbackend.houseloan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        boolean exists = houseloanRepository.existsById(houseLoanId);
        if (!exists) {
            throw new IllegalStateException (
                    "House loan with id " + houseLoanId + " does not exist."
            );
        }
        houseloanRepository.deleteById(houseLoanId);
    }
}
