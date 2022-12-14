package com.mucahitarslan.application.service.rest.movie.service;

import com.mucahitarslan.application.service.rest.movie.converter.MovieConverter;
import com.mucahitarslan.application.service.rest.movie.converter.MovieDirectorConverter;
import com.mucahitarslan.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDetailDTO;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class MovieService {
    private final MovieServiceApplicationDAL movieServiceApplicationDAL;
    private final MovieConverter movieConverter;
    private final MovieDirectorConverter movieDirectorConverter;

    public MovieService(MovieServiceApplicationDAL movieServiceApplicationDAL, MovieConverter movieConverter, MovieDirectorConverter movieDirectorConverter) {
        this.movieServiceApplicationDAL = movieServiceApplicationDAL;
        this.movieConverter = movieConverter;
        this.movieDirectorConverter = movieDirectorConverter;
    }

    private List<MovieDTO> findAllMoviesCallback()
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findAllMovies().spliterator(),false)
                .map(movieConverter::toMovieDto)
                .collect(Collectors.toList());
    }

    private List<MovieDTO> findMoviesByMonthYearCallback(int month, int year)
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findMoviesByMonthYear(month,year).spliterator(),false)
                .map(movieConverter::toMovieDto)
                .collect(Collectors.toList());
    }

    private List<MovieDTO> findMoviesByYearCallback(int year)
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findMoviesByYear(year).spliterator(),false)
                .map(movieConverter::toMovieDto)
                .collect(Collectors.toList());
    }

    private MovieDTO saveMovieCallback(MovieDTO movieDTO)
    {
        movieServiceApplicationDAL.saveMovie(movieConverter.toMovie(movieDTO));
        return movieDTO;
    }

    private List<MovieDetailDTO> findMoviesDetailByYearCallback(int year)
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findMoviesDetailByYear(year).spliterator(),false)
                .map(movieDirectorConverter::toMovieDetailDTO)
                .collect(Collectors.toList());
    }

    public long countMovies()
    {
        return doWorkForService(this::countMovies, "MoviesApplicationService.countMovies");
    }

    public List<MovieDTO> findAllMovies()
    {
        return doWorkForService(this::findAllMoviesCallback,"MoviesApplicationService.findAllMovies");
    }

    public List<MovieDTO> findMoviesByMonthYear(int month, int year)
    {
        return doWorkForService(() -> findMoviesByMonthYearCallback(month,year),"MoviesApplicationService.findMoviesByMonthYear");
    }

    public List<MovieDTO> findMoviesByYear(int year)
    {
        return doWorkForService(() -> findMoviesByYearCallback(year),"MoviesApplicationService.findMoviesByYear");
    }

    public MovieDTO saveMovie(MovieDTO movieDTO)
    {
        return doWorkForService(() -> saveMovieCallback(movieDTO),"MoviesApplicationService.saveMovie");
    }

    public List<MovieDetailDTO> findMoviesDetailsByYear(int year)
    {
        return doWorkForService(() -> findMoviesDetailByYearCallback(year), "MoviesApplicationService.findMoviesDetailsByYear");
    }
}
