package com.mucahitarslan.application.service.rest.movie.converter;

import com.mucahitarslan.application.service.rest.movie.data.entity.Director;
import com.mucahitarslan.application.service.rest.movie.data.entity.MovieDirectorDetail;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class MovieDirectorConverter {
    private final MovieConverter movieConverter;
    private final DirectorConverter directorConverter;

    public MovieDirectorConverter(MovieConverter movieConverter, DirectorConverter directorConverter) {
        this.movieConverter = movieConverter;
        this.directorConverter = directorConverter;
    }

    public MovieDetailDTO toMovieDetailDTO(MovieDirectorDetail movieDirectorDetail)
    {
        var movieDetailDTO = new MovieDetailDTO();

        movieDetailDTO.setMovieDTO(movieConverter.toMovieDto(movieDirectorDetail.getMovie()));
        return movieDetailDTO;
    }
}
