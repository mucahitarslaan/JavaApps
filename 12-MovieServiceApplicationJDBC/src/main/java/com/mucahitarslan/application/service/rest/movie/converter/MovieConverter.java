package com.mucahitarslan.application.service.rest.movie.converter;

import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class MovieConverter {
    private final DateTimeFormatter dateTimeFormatter;

    public MovieConverter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public MovieDTO toMovieDto(Movie movie)
    {
        var movieDTO = new MovieDTO();

        movieDTO.setName(movie.getName());
        movieDTO.setSceneTime(dateTimeFormatter.format(movie.getSceneTime()));
        movieDTO.setRating(movie.getRating());
        movieDTO.setCost(movie.getCost());

        return movieDTO;
    }

    public Movie toMovie(MovieDTO movieDTO)
    {
        // TODO:
        throw new UnsupportedOperationException();
    }

}
