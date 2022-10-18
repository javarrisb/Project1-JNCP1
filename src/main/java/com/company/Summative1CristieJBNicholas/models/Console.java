package com.company.Summative1CristieJBNicholas.models;

import java.util.Objects;

public class Console {
   private Integer console_id;

   private String model;

   private String manufacturer;

   private String memory_amount;

   private String processor;

   private Double price;

   private Integer quantity;

    public Console() {

    }

    public Console(Integer console_id, String model, String manufacturer, String memory_amount, String processor, Double price, Integer quantity) {
        this.console_id = console_id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.memory_amount = memory_amount;
        this.processor = processor;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getConsole_id() {
        return console_id;
    }

    public void setConsole_id(Integer console_id) {
        this.console_id = console_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Console)) return false;
        Console console = (Console) o;
        return getConsole_id().equals(console.getConsole_id()) && Objects.equals(getModel(), console.getModel()) && getManufacturer().equals(console.getManufacturer()) && Objects.equals(getMemory_amount(), console.getMemory_amount()) && Objects.equals(getProcessor(), console.getProcessor()) && getPrice().equals(console.getPrice()) && getQuantity().equals(console.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsole_id(), getModel(), getManufacturer(), getMemory_amount(), getProcessor(), getPrice(), getQuantity());
    }

    @Override
    public String toString() {
        return "Console{" +
                "console_id=" + console_id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memory_amount='" + memory_amount + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}


