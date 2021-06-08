package com.example.loancalculatorbackend.houseloan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseLoanRepository extends JpaRepository<HouseLoan, Long> {
}
