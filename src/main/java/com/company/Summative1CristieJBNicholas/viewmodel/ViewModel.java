package com.company.Summative1CristieJBNicholas.viewmodel;

import com.company.Summative1CristieJBNicholas.models.Invoice;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ViewModel {
    private Integer id;
    private List<Invoice> invoiceList = new ArrayList<>();
    private String name;
    private String city;
    private String state;
    private String zipcode;
    private Integer item_Id;
    private String item_Type;
    private Double unit_price;
    private Double processing_Fee;
    private Double tax;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")


    private Double total;

    public ViewModel() {
    }

    public ViewModel(Integer id, List<Invoice> invoiceList, String name, String city, String state, String zipcode,
                     Integer item_Id, String item_Type, Double unit_price, Double processing_Fee, Double tax, Double total) {
        this.id = id;
        this.invoiceList = invoiceList;
        this.name = name;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.item_Id = item_Id;
        this.item_Type = item_Type;
        this.unit_price = unit_price;
        this.processing_Fee = processing_Fee;
        this.tax = tax;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getItem_Id() {
        return item_Id;
    }

    public void setItem_Id(Integer item_Id) {
        this.item_Id = item_Id;
    }

    public String getItem_Type() {
        return item_Type;
    }

    public void setItem_Type(String item_Type) {
        this.item_Type = item_Type;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Double getProcessing_Fee() {
        return processing_Fee;
    }

    public void setProcessing_Fee(Double processing_Fee) {
        this.processing_Fee = processing_Fee;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewModel viewModel = (ViewModel) o;
        return Objects.equals(id, viewModel.id) && Objects.equals(invoiceList, viewModel.invoiceList) && Objects.equals(name, viewModel.name) && Objects.equals(city, viewModel.city) && Objects.equals(state, viewModel.state) && Objects.equals(zipcode, viewModel.zipcode) && Objects.equals(item_Id, viewModel.item_Id) && Objects.equals(item_Type, viewModel.item_Type) && Objects.equals(unit_price, viewModel.unit_price) && Objects.equals(processing_Fee, viewModel.processing_Fee) && Objects.equals(tax, viewModel.tax) && Objects.equals(total, viewModel.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceList, name, city, state, zipcode, item_Id, item_Type, unit_price, processing_Fee, tax, total);
    }

    @Override
    public String toString() {
        return "ViewModel{" +
                "id=" + id +
                ", invoiceList=" + invoiceList +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", item_Id=" + item_Id +
                ", item_Type='" + item_Type + '\'' +
                ", unit_price=" + unit_price +
                ", processing_Fee=" + processing_Fee +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}
