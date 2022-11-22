package com.mucahitarslan.application.service.rest.movie.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class MovieDetailDTO {
    private MovieDTO movieDTO;
    private String directorName;

    @JsonGetter("movie")
    public MovieDTO getMovieDTO() {
        return movieDTO;
    }

    public void setMovieDTO(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
