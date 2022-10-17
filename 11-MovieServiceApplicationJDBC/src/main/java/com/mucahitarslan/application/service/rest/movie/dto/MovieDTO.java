package com.mucahitarslan.application.service.rest.movie.dto;

import java.math.BigDecimal;

public class MovieDTO {
    private String name;
    private String sceneTime;
    private long rating;
    private BigDecimal cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSceneTime() {
        return sceneTime;
    }

    public void setSceneTime(String sceneTime) {
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
}
