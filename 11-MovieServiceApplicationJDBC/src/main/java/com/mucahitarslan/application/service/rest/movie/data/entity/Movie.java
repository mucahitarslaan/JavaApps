package com.mucahitarslan.application.service.rest.movie.data.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Movie {
    private long id;
    private String name;
    private LocalDate sceneTime;
    private long rating;
    private BigDecimal cost;
    private float imdb;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getSceneTime() {
        return sceneTime;
    }

    public void setSceneTime(LocalDate sceneTime) {
        this.sceneTime = sceneTime;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public float getImdb() {
        return imdb;
    }

    public void setImdb(float imdb) {
        this.imdb = imdb;
    }
}
