package com.mucahitarslan.application.service.rest.movie.service;

import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.data.repository.IMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieApplicationService
{
    private final IMovieRepository iMovieRepository;

    public MovieApplicationService(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }

    public long countMovies()
    {
        return iMovieRepository.count();
    }

    public List<Movie> findAllMovies()
    {
        return StreamSupport.stream(iMovieRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Movie saveMovie(Movie movie)
    {
        return iMovieRepository.save(movie);
    }
}
