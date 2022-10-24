package com.company.Summative1CristieJBNicholas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Digits;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoice")
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")//PK
    private Integer invoiceId;

    @NotEmpty(message = "You must supply a name for the invoice please.")
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "street")
    private String street;
    @NotNull
    @Column(name = "city")
    private String city;
    @NotNull
    @Column(name = "state")
    @Size(max = 2)
    private String state;
    @NotNull
    @Column(name = "zipcode")
    @Size(min = 5, max = 5)
    private String zipcode;
    @NotNull
    @Column(name = "item_type")
    private String itemType;
    @NotNull
    @Column(name = "item_id")
    private Integer itemId;
    @NotNull
    @Column(name = "unit_price")
    @Digits(integer = 5, fraction = 2)
    private Double unitPrice;
    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "subtotal")
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private double subtotal;
    @Column(name = "tax")
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private double tax;
    @Column(name = "processing_fee")
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private double proceesingFee;

    @Column(name = "total")
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private double total;

    public Invoice() {
    }

    public Invoice(Integer invoiceId, String name, String street, String city, String state, String zipcode, String itemType, Integer itemId, Double unitPrice, int quantity, double subtotal, double tax, double proceesingFee, double total) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.itemType = itemType;
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.tax = tax;
        this.proceesingFee = proceesingFee;
        this.total = total;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getProceesingFee() {
        return proceesingFee;
    }

    public void setProceesingFee(double proceesingFee) {
        this.proceesingFee = proceesingFee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return getQuantity() == invoice.getQuantity() && Double.compare(invoice.getSubtotal(), getSubtotal()) == 0 && Double.compare(invoice.getTax(), getTax()) == 0 && Double.compare(invoice.getProceesingFee(), getProceesingFee()) == 0 && Double.compare(invoice.getTotal(), getTotal()) == 0 && Objects.equals(getInvoiceId(), invoice.getInvoiceId()) && Objects.equals(getName(), invoice.getName()) && Objects.equals(getStreet(), invoice.getStreet()) && Objects.equals(getCity(), invoice.getCity()) && Objects.equals(getState(), invoice.getState()) && Objects.equals(getZipcode(), invoice.getZipcode()) && Objects.equals(getItemType(), invoice.getItemType()) && Objects.equals(getItemId(), invoice.getItemId()) && Objects.equals(getUnitPrice(), invoice.getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getUnitPrice(), getQuantity(), getSubtotal(), getTax(), getProceesingFee(), getTotal());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemId=" + itemId +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", proceesingFee=" + proceesingFee +
                ", total=" + total +
                '}';
    }
}
