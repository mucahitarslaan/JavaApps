package com.mucahitarslan.application.service.rest.movie.mapper;

import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-04T05:26:40+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class MovieMapperImpl implements IMovieMapper {

    @Override
    public MovieDTO toMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        if ( movie.sceneTime != null ) {
            movieDTO.setSceneTime( DateTimeFormatter.ofPattern( "dd/MM/yyyy" ).format( movie.sceneTime ) );
        }
        movieDTO.setName( movie.name );
        movieDTO.setRating( movie.rating );
        movieDTO.setCost( movie.cost );

        return movieDTO;
    }

    @Override
    public Movie toMovie(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        if ( movieDTO.getSceneTime() != null ) {
            movie.sceneTime = LocalDate.parse( movieDTO.getSceneTime(), DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) );
        }
        movie.name = movieDTO.getName();
        movie.rating = movieDTO.getRating();
        movie.cost = movieDTO.getCost();

        return movie;
    }
}
