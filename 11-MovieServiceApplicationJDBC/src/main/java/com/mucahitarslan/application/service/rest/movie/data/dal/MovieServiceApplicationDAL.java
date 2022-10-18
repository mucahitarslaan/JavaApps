package com.mucahitarslan.application.service.rest.movie.data.dal;

import com.mucahitarslan.application.service.rest.movie.data.entity.Director;
import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.data.repository.IDirectorRepository;
import com.mucahitarslan.application.service.rest.movie.data.repository.IMovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceApplicationDAL {
    private final IMovieRepository movieRepository;
    private final IDirectorRepository directorRepository;

    public MovieServiceApplicationDAL(IMovieRepository movieRepository, IDirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public long countMovies() {   //...
        return movieRepository.count();
    }

    public Iterable<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public long countDirectors() {
        return directorRepository.count();
    }

    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

    public Iterable<Director> findAllDirectors() {
        return directorRepository.findAll();
    }
}
