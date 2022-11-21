package com.mucahitarslan.application.service.rest.movie.service;

import com.mucahitarslan.application.service.rest.movie.converter.DirectorConverter;
import com.mucahitarslan.application.service.rest.movie.converter.MovieConverter;
import com.mucahitarslan.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import com.mucahitarslan.application.service.rest.movie.data.entity.Director;
import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.data.repository.IDirectorRepository;
import com.mucahitarslan.application.service.rest.movie.data.repository.IMovieRepository;
import com.mucahitarslan.application.service.rest.movie.dto.DirectorDTO;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieApplicationService
{
    private final MovieServiceApplicationDAL movieServiceApplicationDAL;
    private final MovieConverter movieConverter;
    private final DirectorConverter directorConverter;

    public MovieApplicationService(MovieServiceApplicationDAL movieServiceApplicationDAL, MovieConverter movieConverter, DirectorConverter directorConverter) {
        this.movieServiceApplicationDAL = movieServiceApplicationDAL;
        this.movieConverter = movieConverter;
        this.directorConverter = directorConverter;
    }

    public long countMovies()
    {
        return movieServiceApplicationDAL.countMovies();
    }

    public List<MovieDTO> findAllMovies()
    {
        //return StreamSupport.stream(iMovieRepository.findAll().spliterator(), false)
        //        .collect(Collectors.toList());

        return StreamSupport.stream(movieServiceApplicationDAL.findAllMovies().spliterator(),false)
                .map(movieConverter::toMovieDto)
                .collect(Collectors.toList());

    }
    public MovieDTO saveMovie(MovieDTO movieDTO)
    {
        movieServiceApplicationDAL.saveMovie(movieConverter.toMovie(movieDTO));

        return movieDTO;
    }

    public DirectorDTO saveDirector(DirectorDTO directorDTO)
    {
        movieServiceApplicationDAL.saveDirector(directorConverter.toDirector(directorDTO));

        return directorDTO;
    }

    public List<DirectorDTO> findAllDirectors()
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findAllDirectors().spliterator(),false)
                .map(directorConverter::toDirectorDTO)
                .collect(Collectors.toList());
    }
}
