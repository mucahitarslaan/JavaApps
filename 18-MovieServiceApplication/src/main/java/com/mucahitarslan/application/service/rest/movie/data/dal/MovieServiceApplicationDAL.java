package com.mucahitarslan.application.service.rest.movie.data.dal;

import com.mucahitarslan.application.service.rest.movie.data.entity.Director;
import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.data.repository.IDirectorRepository;
import com.mucahitarslan.application.service.rest.movie.data.repository.IMovieRepository;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;
@Component
public class MovieServiceApplicationDAL {
    private final IMovieRepository movieRepository;
    private final IDirectorRepository directorRepository;

    public MovieServiceApplicationDAL(IMovieRepository movieRepository, IDirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public long countMovies() {   //...
        return doWorkForRepository(movieRepository::count,"MovieServiceApplicationDAL.countMovies");
    }

    public Iterable<Movie> findAllMovies() {
        return doWorkForRepository(movieRepository::findAll,"MovieServiceApplicationDAL.findAllMovies");
    }

    public Iterable<Movie> findMoviesByMonthYear(int month, int year)
    {
        return doWorkForRepository(() -> findMoviesByMonthYear(month,year), "MovieServiceApplicationDAL.findMoviesByMonthYear");
    }

    public Iterable<Movie> findMoviesByYear(int year)
    {
        return doWorkForRepository(() -> movieRepository.findMoviesByYear(year), "MovieServiceApplicationDAL.findMoviesByYear");
    }


    public Movie saveMovie(Movie movie)
    {
        return doWorkForRepository(() -> movieRepository.save(movie), "MovieServiceApplicationDAL.saveMovie");
    }

    public long countDirectors()
    {
        return doWorkForRepository(directorRepository::count, "MovieServiceApplicationDAL.countDirectors");
    }

    public Director saveDirector(Director director)
    {
        return doWorkForRepository(() -> directorRepository.save(director), "MovieServiceApplicationDAL.saveDirector");
    }

    public Iterable<Director> findAllDirectors()
    {
        return doWorkForRepository(directorRepository::findAll, "MovieServiceApplicationDAL.findAllDirectors");
    }
}
