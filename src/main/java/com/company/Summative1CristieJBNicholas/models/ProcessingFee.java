package com.company.Summative1CristieJBNicholas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "processingFee")


public class ProcessingFee {
    @Id
    private String consoles;
    private String tShirts;
    private String games;

    @Column(name = "processing_Fee")
    private Double processingFee;

    public ProcessingFee(){

    }

    public ProcessingFee(String consoles, String tShirts, String games, Double processingFee) {
        this.consoles = consoles;
        this.tShirts = tShirts;
        this.games = games;
        this.processingFee = processingFee;
    }

    public String getConsoles() {
        return consoles;
    }

    public void setConsoles(String consoles) {
        this.consoles = consoles;
    }

    public String gettShirts() {
        return tShirts;
    }

    public void settShirts(String tShirts) {
        this.tShirts = tShirts;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public Double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(Double processingFee) {
        this.processingFee = processingFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessingFee)) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Objects.equals(getConsoles(), that.getConsoles()) && Objects.equals(gettShirts(), that.gettShirts()) && Objects.equals(getGames(), that.getGames()) && Objects.equals(getProcessingFee(), that.getProcessingFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsoles(), gettShirts(), getGames(), getProcessingFee());
    }

    @Override
    public String toString() {
        return "ProcessingFee{" +
                "consoles='" + consoles + '\'' +
                ", tShirts='" + tShirts + '\'' +
                ", games='" + games + '\'' +
                ", processingFee=" + processingFee +
                '}';
    }
}
