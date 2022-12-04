package com.mucahitarslan.application.service.rest.movie.service;

import com.mucahitarslan.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import com.mucahitarslan.application.service.rest.movie.mapper.IMovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class MovieService {
    private final MovieServiceApplicationDAL movieServiceApplicationDAL;
    private final IMovieMapper movieMapper;

    public MovieService(MovieServiceApplicationDAL movieServiceApplicationDAL, IMovieMapper movieMapper) {
        this.movieServiceApplicationDAL = movieServiceApplicationDAL;
        this.movieMapper = movieMapper;
    }

    private List<MovieDTO> findAllMoviesCallback()
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findAllMovies().spliterator(),false)
                .map(movieMapper::toMovieDTO)
                .collect(Collectors.toList());
    }

    private List<MovieDTO> findMoviesByMonthYearCallback(int month, int year)
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findMoviesByMonthYear(month,year).spliterator(),false)
                .map(movieMapper::toMovieDTO)
                .collect(Collectors.toList());
    }

    private MovieDTO saveMovieCallback(MovieDTO movieDTO)
    {
        movieServiceApplicationDAL.saveMovie(movieMapper.toMovie(movieDTO));
        return movieDTO;
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


    public MovieDTO saveMovie(MovieDTO movieDTO)
    {
        return doWorkForService(() -> saveMovieCallback(movieDTO),"MoviesApplicationService.saveMovie");
    }

    private List<MovieDTO> findMoviesByYearCallback(int year)
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findMoviesByYear(year).spliterator(),false)
                .map(movieMapper::toMovieDTO)
                .collect(Collectors.toList());
    }
    public List<MovieDTO> findMoviesByYear(int year)
    {
        return doWorkForService(() -> findMoviesByYearCallback(year), "MovieApplicationService.findMoviesByYear");
    }
}
