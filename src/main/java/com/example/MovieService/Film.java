package com.example.MovieService;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;


@Table(name = "film")
@Entity
public class Film {

    @Schema(description = "ID of The Movie")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Integer id;
    @Schema(description = "Title of The Movie")
    @Column(name= "title")
    private String name;

    @Schema(description = "Category of The Movie")
    @Column(name= "type")
    @Enumerated(EnumType.STRING)
    private category kategoria;
    @Schema(description = "How long is The Movie")
    @Column(name= "numer_of_min")
    private int number_of_minute;
    @Schema(description = "Is Movie Avaible")
    @Column(name = "is_Avaible", nullable = false)
    private boolean is_Available;

    public Film() {
    }

    public Film(Integer id, String name, category kategoria, int number_of_minute) {
        this.id = id;
        this.name = name;
        this.kategoria = kategoria;
        this.number_of_minute = number_of_minute;
        this.is_Available = false;
    }

    public boolean isIs_Available() {
        return is_Available;
    }

    public void setIs_Available(boolean avaible) {
        is_Available = avaible;
    }

    public Integer getId() {
        return id;
    }

    public int getNumber_of_minute() {
        return number_of_minute;
    }

    public void setNumber_of_minute(int number_of_minute) {
        this.number_of_minute = number_of_minute;
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

    public category getKategoria() {
        return kategoria;
    }

    public void setKategoria(category kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kategoria=" + kategoria +
                ", number_of_minute=" + number_of_minute +
                ", isAvaible=" + is_Available +
                '}';
    }
}
