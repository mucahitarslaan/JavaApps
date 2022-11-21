package com.mucahitarslan.application.service.rest.movie.data.entity;

import java.time.LocalDate;

public class Director {
    private long id;
    private String name;
    private LocalDate birthdate;

    public Director()
    {
    }

    public Director(long id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
