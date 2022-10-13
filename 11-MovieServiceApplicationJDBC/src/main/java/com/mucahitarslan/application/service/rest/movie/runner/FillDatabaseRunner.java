package com.mucahitarslan.application.service.rest.movie.runner;

import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.data.repository.IMovieRepository;
import org.csystem.util.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class FillDatabaseRunner implements ApplicationRunner {

    private final IMovieRepository movieRepository;

    public FillDatabaseRunner(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        movieRepository.findAll().forEach(Console::writeLine);

    }
}
