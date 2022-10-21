package com.company.Summative1CristieJBNicholas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tax_Rate", indexes = {@Index(name = "state_rate", columnList = "state")})
public class TaxRate {

    @Id
    @NotNull
    @Size(min = 2, max = 2)
    private String state;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private Double rate;

    public TaxRate() {
    }

    public TaxRate(String state, Double rate) {
        this.state = state;
        this.rate = rate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxRate taxRate = (TaxRate) o;
        return Objects.equals(getState(), taxRate.getState()) && Objects.equals(getRate(), taxRate.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), getRate());
    }

    @Override
    public String toString() {
        return "TaxRate{" +
                "state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}
