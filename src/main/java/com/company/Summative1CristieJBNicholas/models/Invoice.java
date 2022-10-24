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
    private Integer  invoice_id;
    /**made into invoice_id */
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
    @Column(name="item_type")
    private String item_type;
    @NotNull
    @Column(name="item_id")
    private Integer item_id;
    @NotNull
    @Column(name="unit_price")
    @Digits(integer = 5, fraction = 2)
    private Double unit_price;
    @NotNull
    @Column(name="quantity")
    private int quantity;

    @Column(name = "subtotal")
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private double subtotal;
    @Column(name="tax")
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private double tax;
    @Column(name="processing_fee")
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private double processing_fee;

    @Column(name="total")
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private double total;

    public Invoice(){

    }
    public Invoice( Integer invoice_id, String name, String street, String city, String state, String zipcode,
                    Integer item_id, double unit_price, int quantity, double subtotal) {
        this.invoice_id = invoice_id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_id = item_id;
        this.item_type = item_type;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.processing_fee = processing_fee;
        this.tax = tax;
        this.total = total;
    }
    public Invoice( Integer invoice_id,String name, String street, String city, String state, String zipcode,
                    String item_type, int item_id, double unit_price, int quantity){
        this.invoice_id = invoice_id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_type = item_type;
        this.item_id = item_id;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }

    public Invoice( String name, String street, String city, String state, String zipcode,
                    String item_type, int item_id, double unit_price, int quantity) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_type = item_type;
        this.item_id = item_id;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }

    public Invoice(Integer invoice_id, String name, String street, String city, String state, String zipcode,
                   Integer item_id, String item_type, double unit_price, int quantity, double subtotal,
                   double processing_fee, double tax, double total) {
        this.invoice_id = invoice_id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_id = item_id;
        this.item_type = item_type;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.processing_fee = processing_fee;
        this.tax = tax;
        this.total = total;
    }

    public Invoice(Integer invoice_id, String name, String street, String city, String state, String zipcode,
                   Integer item_id, String item_type, double unit_price, int quantity, double subtotal) {
        this.invoice_id = invoice_id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_id = item_id;
        this.item_type = item_type;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
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

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubtotal(double subtotal){
        this.subtotal = subtotal;
    }
    public double getSubtotal(){
        return subtotal;
    }
    public double getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(double processing_fee) {
        this.processing_fee = processing_fee;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
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
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.unit_price, unit_price) == 0 && quantity == invoice.quantity && Double.compare(invoice.processing_fee, processing_fee) == 0 && Double.compare(invoice.tax, tax) == 0 && Double.compare(invoice.total, total) == 0 && Objects.equals(invoice_id, invoice.invoice_id) && Objects.equals(name, invoice.name) && Objects.equals(street, invoice.street) && Objects.equals(city, invoice.city) && Objects.equals(state, invoice.state) && Objects.equals(zipcode, invoice.zipcode) && Objects.equals(item_id, invoice.item_id) && Objects.equals(item_type, invoice.item_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_id, name, street, city, state, zipcode, item_id, item_type, unit_price, quantity, processing_fee, tax, total);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_id=" + invoice_id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", item_id=" + item_id +
                ", item_type='" + item_type + '\'' +
                ", unit_price=" + unit_price +
                ", quantity=" + quantity +
                ", processing_fee=" + processing_fee +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}