package com.example.loancalculatorbackend.houseloan;


import javax.persistence.*;

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
    private Integer amount;
    private Integer years;
    // Will not be initialized by end user.
    private Integer term;
    private Integer installment;
    private Integer interest;
    private Integer principal;
    private Integer outstandingDebt;

    // Probably not necessary
    public HouseLoan() {
    }

    public HouseLoan(Long id, Integer amount, Integer years) {
        this.id = id;
        this.amount = amount;
        this.years = years;
    }

    // Kill it
    public HouseLoan(Long id, Integer amount, Integer years, Integer term, Integer installment, Integer interest, Integer principal, Integer outstandingDebt) {
        this.id = id;
        this.amount = amount;
        this.years = years;
        this.term = term;
        this.installment = installment;
        this.interest = interest;
        this.principal = principal;
        this.outstandingDebt = outstandingDebt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Integer getInterest() {
        return interest;
    }

    public void setInterest(Integer interest) {
        this.interest = interest;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    public Integer getOutstandingDebt() {
        return outstandingDebt;
    }

    public void setOutstandingDebt(Integer outstandingDebt) {
        this.outstandingDebt = outstandingDebt;
    }

    @Override
    public String toString() {
        return "HouseLoan{" +
                "id=" + id +
                ", amount=" + amount +
                ", years=" + years +
                ", term=" + term +
                ", installment=" + installment +
                ", interest=" + interest +
                ", principal=" + principal +
                ", outstandingDebt=" + outstandingDebt +
                '}';
    }
}
