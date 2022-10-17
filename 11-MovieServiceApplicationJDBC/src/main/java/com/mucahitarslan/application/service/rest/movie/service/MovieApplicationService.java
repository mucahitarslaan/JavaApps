package com.mucahitarslan.application.service.rest.movie.service;

import com.mucahitarslan.application.service.rest.movie.converter.MovieConverter;
import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.data.repository.IMovieRepository;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieApplicationService
{
    private final IMovieRepository iMovieRepository;
    private final MovieConverter movieConverter;

    public MovieApplicationService(IMovieRepository iMovieRepository, MovieConverter movieConverter) {
        this.iMovieRepository = iMovieRepository;
        this.movieConverter = movieConverter;
    }

    public long countMovies()
    {
        return iMovieRepository.count();
    }

    public List<MovieDTO> findAllMovies()
    {
        //return StreamSupport.stream(iMovieRepository.findAll().spliterator(), false)
        //        .collect(Collectors.toList());

        return StreamSupport.stream(iMovieRepository.findAll().spliterator(),false)
                .map(movieConverter::toMovieDto)
                .collect(Collectors.toList());

    }

    public Movie saveMovie(Movie movie)
    {
        return iMovieRepository.save(movie);
    }
}
