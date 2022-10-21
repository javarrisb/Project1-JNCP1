package com.company.Summative1CristieJBNicholas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Digits;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    private Integer  id;

    @NotEmpty(message = "You must supply a name for the invoice please.")
    @Column(name = "name")
    private String name;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    @Size(max = 2)
    private String state;
    @Column(name = "zipcode")
    @Size(min = 5, max = 5)
    private String zipcode;
    @Column(name="item_id")
    private Integer item_id;
    @Column(name="item_type")
    private String item_type;
    @Column(name="unit_price")
    @Digits(integer = 5, fraction = 2)
    private double unit_price;
    @Column(name="quantity")
    private int quantity;

    @Column(name = "subtotal")
    @Digits(integer = 5, fraction = 2)
    private double subtotal;
    @Column(name="processing_fee")
    @Digits(integer = 5, fraction = 2)
    private double processing_fee;
    @Column(name="tax")
    @Digits(integer = 5, fraction = 2)
    private double tax;
    @Column(name="total")
    @Digits(integer = 5, fraction = 2)
    private double total;


    public Invoice(){

    }

//    public Invoice(int id, String name, String street, String city, String state, String zipcode) {
//        this.id = id;
//        this.name = name;
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.zipcode = zipcode;
//    }

    public Invoice(Integer id, String name, String street, String city, String state, String zipcode,
                   Integer item_id, String item_type, double unit_price, int quantity, double subtotal,
                   double processing_fee, double tax, double total) {
        this.id = id;
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

    public Invoice(Integer id, String name, String street, String city, String state, String zipcode, Integer item_id, String item_type, double unit_price, int quantity, double subtotal) {
        this.id = id;
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
//    public Invoice(int i, String william_shatner, String s, String roswell, String nm, int i1, int i2, String console, double v, int i3, double v1) {
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return Double.compare(invoice.unit_price, unit_price) == 0 && quantity == invoice.quantity && Double.compare(invoice.processing_fee, processing_fee) == 0 && Double.compare(invoice.tax, tax) == 0 && Double.compare(invoice.total, total) == 0 && Objects.equals(id, invoice.id) && Objects.equals(name, invoice.name) && Objects.equals(street, invoice.street) && Objects.equals(city, invoice.city) && Objects.equals(state, invoice.state) && Objects.equals(zipcode, invoice.zipcode) && Objects.equals(item_id, invoice.item_id) && Objects.equals(item_type, invoice.item_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipcode, item_id, item_type, unit_price, quantity, processing_fee, tax, total);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
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
// invoice_id int not null auto_increment primary key,
//    name varchar(80) not null,
//    street varchar(30) not null,
//    city varchar(30) not null,
//    state char(2) not null,
//    zipcode varchar(5) not null,
//    item_type varchar(20) not null,
//    item_id int not null,
//    unit_price decimal(5,2) not null,
//    quantity int not null,
//    subtotal decimal(5,2) not null,
//    tax decimal(5,2) not null,
//    processing_fee decimal (5,2) not null,
//    total decimal(5,2) not null
//
//Create
//   Read
//  Read All
//  By Customer Name

