package com.example.loancalculatorbackend.houseloan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table
public class HouseLoan {
    @Id
    @SequenceGenerator(
            name = "houseloan_sequence",
            sequenceName = "houseloan_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "houseloan_sequence"
    )

    private Long id;
    private Double amount;
    private Integer years;
    private Double interest;
    private Double calculatedInterest;
    private Integer calculatedPayments;
    private Double principal;
    private ArrayList<Double> installment;
    private ArrayList<Double> interestRate;
    private Double outstandingDebt;
    private ArrayList<Double> outstandingDebtList;
    private ArrayList<Integer> term;



    // Probably not necessary
    public HouseLoan() {
    }

    public HouseLoan(Long id, Double amount, Integer years) {
        this.id = id;
        this.amount = amount;
        this.years = years;

        this.interest = 3.5;
        this.calculatedInterest = this.interest / 100 / 12;
        this.calculatedPayments = years * 12;
        this.principal = amount / (years * 12); // Need to check for zero.
        this.outstandingDebt = amount;

        this.installment = new ArrayList<Double>(calculatedPayments);
        this.interestRate = new ArrayList<Double>(calculatedPayments);
        this.outstandingDebtList = new ArrayList<Double>(calculatedPayments);
        this.term = new ArrayList<Integer>(calculatedPayments);

        // Error

        for (Integer i = 0; i < calculatedPayments; i++) {
            Double installment = principal + calculatedInterest * outstandingDebt;

            this.term.add(i+1);
            this.interestRate.add(calculatedInterest * outstandingDebt);
            this.installment.add(installment);
            this.outstandingDebt = outstandingDebt - principal;
            this.outstandingDebtList.add(outstandingDebt);
        }
    };


    // Kill it
   /* public HouseLoan(Long id, Integer amount, Integer years, Integer term, Integer installment, Integer interest, Integer principal, Integer outstandingDebt) {
        this.id = id;
        this.amount = amount;
        this.years = years;
        this.term = term;
        this.installment = installment;
        this.interest = interest;
        this.principal = principal;
        this.outstandingDebt = outstandingDebt;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getCalculatedInterest() {
        return calculatedInterest;
    }

    public void setCalculatedInterest(Double calculatedInterest) {
        this.calculatedInterest = calculatedInterest;
    }

    public Integer getCalculatedPayments() {
        return calculatedPayments;
    }

    public void setCalculatedPayments(Integer calculatedPayments) {
        this.calculatedPayments = calculatedPayments;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public ArrayList<Double> getInstallment() {
        return installment;
    }

    public void setInstallment(ArrayList<Double> installment) {
        this.installment = installment;
    }

    public ArrayList<Double> getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(ArrayList<Double> interestRate) {
        this.interestRate = interestRate;
    }

    public Double getOutstandingDebt() {
        return outstandingDebt;
    }

    public void setOutstandingDebt(Double outstandingDebt) {
        this.outstandingDebt = outstandingDebt;
    }

    public ArrayList<Double> getOutstandingDebtList() {
        return outstandingDebtList;
    }

    public void setOutstandingDebtList(ArrayList<Double> outstandingDebtList) {
        this.outstandingDebtList = outstandingDebtList;
    }

    public ArrayList<Integer> getTerm() {
        return term;
    }

    public void setTerm(ArrayList<Integer> term) {
        this.term = term;
    }
}
