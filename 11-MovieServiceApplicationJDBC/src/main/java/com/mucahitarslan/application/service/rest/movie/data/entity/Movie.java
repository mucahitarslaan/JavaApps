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

    public Movie()
    {

    }

    public Movie(long id, String name, LocalDate sceneTime, long rating, BigDecimal cost, float imdb) {
        this.id = id;
        this.name = name;
        this.sceneTime = sceneTime;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }

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

    @Override
    public String toString() {
        return String.format("[%d]%s-%s-%d-%s-%f",id,name,sceneTime,rating,cost,imdb);
    }
}
