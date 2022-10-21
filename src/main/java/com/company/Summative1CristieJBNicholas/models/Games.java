package com.company.Summative1CristieJBNicholas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "game")
public class Games {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer game_Id;

    private String title;
    @Column(name="esrb_rating")
    private String esrbRating;

    private String description;

    private Double price;

    private String studio;

    private Integer quantity;

    public Games(Integer game_Id, String title, String esrbRating, String description, Double price, String studio, Integer quantity) {
        this.game_Id = game_Id;
        this.title = title;
        this.esrbRating = esrbRating;
        this.description = description;
        this.price = price;
        this.studio = studio;
        this.quantity = quantity;
    }

    public Games() {
    }

    public Integer getGame_Id() {
        return game_Id;
    }

    public void setGame_Id(Integer game_Id) {
        this.game_Id = game_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return Objects.equals(getGame_Id(), games.getGame_Id()) && Objects.equals(getTitle(), games.getTitle()) &&
                Objects.equals(getEsrbRating(), games.getEsrbRating()) && Objects.equals(getDescription(),
                games.getDescription()) && Objects.equals(getPrice(), games.getPrice()) && Objects.equals(getStudio(),
                games.getStudio()) && Objects.equals(getQuantity(), games.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGame_Id(), getTitle(), getEsrbRating(), getDescription(), getPrice(), getStudio(), getQuantity());
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + game_Id +
                ", title='" + title + '\'' +
                ", esrbRating='" + esrbRating + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
