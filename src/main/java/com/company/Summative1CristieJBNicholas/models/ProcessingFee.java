package com.company.Summative1CristieJBNicholas.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "processing_fee", indexes = {@Index(name = "ix_product_type_fee" , columnList = "product_type")})
public class ProcessingFee {
    @Id
    @NotNull
    @Size(max = 25)
    @Column(name = "product_type")
    private String productType;

//    private String consoles;
//    private String tShirts;
//    private String games;
    @NotNull
    @Digits(integer = 4, fraction = 2)
    private double fee;

//    @Column(name = "processing_Fee")
//    private Double processingFee;

    public ProcessingFee(){

    }

//    public ProcessingFee(String consoles, String tShirts, String games, Double processingFee) {
//        this.consoles = consoles;
//        this.tShirts = tShirts;
//        this.games = games;
//        this.processingFee = processingFee;
//    }
      public ProcessingFee(String productType, double fee) {
        this.productType = productType;
        this.fee = fee;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
//    public String getConsoles() {
//        return consoles;
//    }

//    public void setConsoles(String consoles) {
//        this.consoles = consoles;
//    }

//    public String gettShirts() {
//        return tShirts;
//    }
//
//    public void settShirts(String tShirts) {
//        this.tShirts = tShirts;
//    }
//
//    public String getGames() {
//        return games;
//    }

//    public void setGames(String games) {
//        this.games = games;
//    }
//
//    public Double getProcessingFee() {
//        return processingFee;
//    }
//
//    public void setProcessingFee(Double processingFee) {
//        this.processingFee = processingFee;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Double.compare(that.fee, fee) == 0 && Objects.equals(productType, that.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, fee);
    }

    @Override
    public String toString() {
        return "ProcessingFee{" +
                "productType='" + productType + '\'' +
                ", fee=" + fee +
                '}';
    }
}
