package com.mucahitarslan.application.service.rest.movie.data.repository;

import com.mucahitarslan.application.service.rest.movie.converter.MovieDirectorConverter;
import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.data.entity.MovieDirectorDetail;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDetailDTO;
import org.csystem.util.data.repository.ICrudRepository;

import java.util.Optional;

public interface IMovieRepository extends ICrudRepository<Movie,Long> {

    Iterable<Movie> findMoviesByYear(int year);
    Iterable<Movie> findMoviesByMonthYear(int month, int year);
    Iterable<MovieDirectorDetail> findMoviesDetailsByYear(int year);
}
