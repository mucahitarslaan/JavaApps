package com.mucahitarslan.application.service.rest.movie.data.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data
@RequiredArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    public long id;

    @Column(nullable = false)
    public String name;

    @Column(name = "scene_time",nullable = false)
    public LocalDate sceneTime;

    @Column(nullable = false)
    public long rating;

    @Column(nullable = false)
    public BigDecimal cost;

    public float imdb;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    Set<Director> directors = new HashSet<>();

}
