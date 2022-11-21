package com.mucahitarslan.application.service.rest.movie.controller;

import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import com.mucahitarslan.application.service.rest.movie.service.MovieApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class MovieController {
    private final MovieApplicationService movieApplicationService;

    public MovieController(MovieApplicationService movieApplicationService) {
        this.movieApplicationService = movieApplicationService;
    }

    @GetMapping("/movies")
    public List<MovieDTO> findAll()
    {
        return movieApplicationService.findAllMovies();
    }

    @GetMapping("/count")
    public long count()
    {
        return movieApplicationService.countMovies();
    }

}
