package com.mucahitarslan.application.service.rest.movie.data.repository;
import com.mucahitarslan.application.service.rest.movie.data.entity.Director;
import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.data.entity.MovieDirectorDetail;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class MovieRepository implements IMovieRepository{

    private static final String COUNT_SQL = "select count(*) from movies";
    private static final String FIND_ALL_SQL = "select * from movies";
    private static final String FIND_BY_MONTH_YEAR_SQL = "select * from movies where date_part('month', scene_time) = :month and date_part('year', scene_time) = :year";
    private static final String FIND_BY_YEAR_SQL = "select * from movies where date_part('year', scene_time) = :year";
    private static final String SAVE_SQL = "insert into movies (name, rating, scene_time, cost, imdb) values (:name, :rating, :sceneTime, :cost, :imdb)";
    private static final String FIND_BY_YEAR_DETAILED_SQL = "select m.name, m.scene_time, m.rating, m.cost, d.name "+
            "from directors d inner join movies_to_director md on md.director_id = d.director_id inner join " +
            "movies m on md.movie_id = m.movie_id where date_part('year', m.scene_time) = :year";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static void fillCounts (ResultSet resultSet,ArrayList<Long> counts) throws SQLException
    {
        do {
            counts.add(resultSet.getLong(1));
        }while (resultSet.next());
    }

    private static void fillMovies(ResultSet resultSet, ArrayList<Movie> movies) throws SQLException
    {
        do {
            var id = resultSet.getLong(1);
            var name = resultSet.getString(2);
            var sceneTime = resultSet.getDate(3).toLocalDate();
            var rating = resultSet.getLong(4);
            var cost = resultSet.getBigDecimal(5);
            var imdb = resultSet.getFloat(6);

            movies.add(new Movie(id,name,sceneTime,rating,cost,imdb));
        }while (resultSet.next());
    }

    private static void fillMoviesDetails(ResultSet resultSet, ArrayList<MovieDirectorDetail> details) throws SQLException
    {
        do {
            var movieName = resultSet.getString(1);
            var sceneTime = resultSet.getDate(2).toLocalDate();
            var rating = resultSet.getLong(3);
            var cost = resultSet.getBigDecimal(4);
            var directorName = resultSet.getString(5);

            var movie = new Movie(movieName,sceneTime,rating,cost,0);
            var director = new Director(directorName);
            details.add(new MovieDirectorDetail(movie,director));
        }while (resultSet.next());
    }


    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public long count() {
        var counts = new ArrayList<Long>();

        jdbcTemplate.query(COUNT_SQL, (ResultSet rs)  -> fillCounts(rs,counts));

        return counts.get(0);

    }


    @Override
    public Iterable<Movie> findAll() {
        var movies = new ArrayList<Movie>();

        jdbcTemplate.query(FIND_ALL_SQL, (ResultSet rs) -> fillMovies(rs,movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findMoviesByYear(int year)
    {
        //TODO:
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findMoviesByMonthYear(int month, int year)
    {
        //TODO:
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Movie> S save(S movie) {
        var keyHolder = new GeneratedKeyHolder();
        var parameterSource = new BeanPropertySqlParameterSource(movie);

        parameterSource.registerSqlType("sceneTime", Types.DATE);

        jdbcTemplate.update(SAVE_SQL,parameterSource,keyHolder,new String[]{"movie_id"});

        movie.setId(keyHolder.getKey().longValue());
        return movie;
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
    public Iterable<Movie> findAllById(Iterable<Long> longs) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        throw new UnsupportedOperationException();

    }

    @Override
    public <S extends Movie> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Iterable<MovieDirectorDetail> findMoviesDetailsByYear(int year) {
        throw new UnsupportedOperationException();
    }
}
