package com.mucahitarslan.application.service.rest.movie.controller;

import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import com.mucahitarslan.application.service.rest.movie.dto.exception.ErrorInfo;
import com.mucahitarslan.application.service.rest.movie.service.MovieService;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.csystem.util.exception.ExceptionUtil.subscribe;

@RestController
@RequestMapping("api/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<MovieDTO> findAll()
    {
        return subscribe(movieService::findAllMovies, ex -> new ArrayList<>());
    }

    @GetMapping("/info")
    public List<MovieDTO> findMovieByYear(@RequestParam("year") int year)
    {
        return subscribe(() -> movieService.findMoviesByYear(year), ex -> new ArrayList<>());
    }

    @GetMapping("/infos")
    public List<MovieDTO> findMovieByYear(@RequestParam("year") String year)
    {
        return subscribe(() -> movieService.findMoviesByYear(Integer.parseInt(year)), ex -> new ArrayList<>());
    }

    @GetMapping("/infosre")
    public ResponseEntity<List<MovieDTO>> findMovieByYearResponseEntity(@RequestParam("year") String yearStr) {
        ResponseEntity<List<MovieDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(movieService.findMoviesByYear(Integer.parseInt(yearStr)));
        } catch (DataServiceException | NumberFormatException ex) {
            //...
        }
        return responseEntity;
    }

    @GetMapping("/count")
    public long count()
    {
        return subscribe(movieService::countMovies, ex -> -1L);
    }

    public ResponseEntity<Object> saveMovie(@RequestBody MovieDTO movieDTO)
    {
        return subscribe(() -> ResponseEntity.ok(movieService.saveMovie(movieDTO)),
                ex -> new ResponseEntity<>(new ErrorInfo(ex.getMessage() , null), HttpStatus.BAD_REQUEST));
    }

    /*
    @GetMapping("/info/detail")
    public ResponseEntity<List<MovieDetailDTO>> findMoviesDetailsByYear(@RequestParam("year") String yearStr) {
        ResponseEntity<List<MovieDetailDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(movieService.findMoviesDetailsByYear(Integer.parseInt(yearStr)));
        } catch (DataServiceException | NumberFormatException ex) {
            //...
        }
        return responseEntity;
    }

    @GetMapping("/info/detailstat")
    public ResponseEntity<Object> findMoviesDetailsByYearStatus(@RequestParam("year") String yearStr)
    {
        return subscribe(() -> ResponseEntity.ok(movieService.findMoviesDetailsByYear(Integer.parseInt(yearStr))),
                ex -> new ResponseEntity<>(new ErrorInfo(ex.getMessage(), yearStr) , HttpStatus.BAD_REQUEST));
    }

     */
}
