package com.mucahitarslan.application.service.rest.movie.data.repository;
import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MovieRepository implements IMovieRepository{

    private static final String SAVE_SQL=""
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie entity) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Iterable<Movie> findAll() {
        throw new UnsupportedOperationException();

    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        throw new UnsupportedOperationException();

    }

    @Override
    public <S extends Movie> S save(S entity) {
        throw new UnsupportedOperationException();

    }

    @Override
    public <S extends Movie> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException();

    }
}
