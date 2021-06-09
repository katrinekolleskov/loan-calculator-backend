package com.example.loancalculatorbackend.houseloan;

import javax.persistence.*;
import java.util.ArrayList;

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
    @Transient
    private Double interest;
    @Transient
    private Double calculatedInterest;
    @Transient
    private Integer calculatedPayments;
    @Transient
    private Double principal;
    @Transient
    private ArrayList<Double> installment;
    @Transient
    private ArrayList<Double> interestRate;
    @Transient
    private Double outstandingDebt; // Not really necessary since it does the same thing as amount, but I thought it was cleaner code reading-wise, but confusing for the user of the api.
    @Transient
    private ArrayList<Double> outstandingDebtList;
    @Transient
    private ArrayList<Integer> term;



    // Not necessary
    public HouseLoan() {
    }

    public HouseLoan(Double amount, Integer years) {
        this.amount = amount;
        this.years = years;
    };


    public Long getId() {
        return id;
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
        return 3.5;
    }

    public Double getCalculatedInterest() {
        return getInterest() / 100 / 12;
    }

    public Integer getCalculatedPayments() {
        return years * 12;
    }


    public Double getPrincipal() {
        return getAmount() / (getYears() * 12);
    }

    public ArrayList<Double> getInstallment() {
        ArrayList<Double> installmentList = new ArrayList<Double>(getCalculatedPayments());
        Double outstandingDebt = getOutstandingDebt();

        for (Integer i = 0; i < getCalculatedPayments(); i++) {
            Double installment = getPrincipal() + getCalculatedInterest() * outstandingDebt;
            installmentList.add(installment);
            outstandingDebt = outstandingDebt - getPrincipal();
        }
        return installmentList;
    }

    public ArrayList<Double> getInterestRate() {
        ArrayList<Double> interestRate = new ArrayList<Double>(getCalculatedPayments());
        Double outstandingDebt = getOutstandingDebt();

        for (Integer i = 0; i < getCalculatedPayments(); i++) {
           interestRate.add(getCalculatedInterest() * outstandingDebt);
           outstandingDebt = outstandingDebt - getPrincipal();
        }
        return interestRate;
    }

    public Double getOutstandingDebt() {
        return getAmount();
    }

    public ArrayList<Double> getOutstandingDebtList() {
        ArrayList<Double> outstandingDebtList = new ArrayList<Double>(getCalculatedPayments());
        Double outstandingDebt = getOutstandingDebt();

        for (Integer i = 0; i < getCalculatedPayments(); i++) {
            outstandingDebt = outstandingDebt - getPrincipal();
            outstandingDebtList.add(outstandingDebt);
        }
        return outstandingDebtList;
    }

    public ArrayList<Integer> getTerm() {
        ArrayList<Integer> term = new ArrayList<Integer>(getCalculatedPayments());

        for (Integer i = 0; i < getCalculatedPayments(); i++) {
            term.add(i+1);
        }
        return term;
    }

    @Override
    public String toString() {
        return "HouseLoan{" +
                "id=" + id +
                ", amount=" + amount +
                ", years=" + years +
                ", interest=" + interest +
                '}';
    }
}
