package com.mucahitarslan.application.service.rest.movie.controller;

import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import com.mucahitarslan.application.service.rest.movie.service.DirectorService;
import com.mucahitarslan.application.service.rest.movie.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class MovieController {
    private final DirectorService directorService;
    private final MovieService movieService;

    public MovieController(DirectorService directorService, MovieService movieService) {
        this.directorService = directorService;
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieDTO> findAll()
    {
        return movieService.findAllMovies();
    }

    @GetMapping("/count")
    public long count()
    {
        return movieService.countMovies();
    }

}
