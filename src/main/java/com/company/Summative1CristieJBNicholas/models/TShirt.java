package com.company.Summative1CristieJBNicholas.models;

import java.util.Objects;

public class TShirt {
    private Integer t_shirt_id;

    private String size;

    private String color;

    private String description;

    private Double price;

    private Integer quantity;

    public TShirt() {

    }

    public TShirt(Integer t_shirt_id, String size, String color, String description, Double price, Integer quantity) {
        this.t_shirt_id = t_shirt_id;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getT_shirt_id() {
        return t_shirt_id;
    }

    public void setT_shirt_id(Integer t_shirt_id) {
        this.t_shirt_id = t_shirt_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(o instanceof TShirt)) return false;
        TShirt tShirt = (TShirt) o;
        return getT_shirt_id().equals(tShirt.getT_shirt_id()) && getSize().equals(tShirt.getSize()) && getColor().equals(tShirt.getColor()) && getDescription().equals(tShirt.getDescription()) && getPrice().equals(tShirt.getPrice()) && getQuantity().equals(tShirt.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getT_shirt_id(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "t_shirt_id=" + t_shirt_id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}



