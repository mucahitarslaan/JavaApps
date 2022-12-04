package com.mucahitarslan.application.service.rest.movie.mapper;

import com.mucahitarslan.application.service.rest.movie.data.entity.Movie;
import com.mucahitarslan.application.service.rest.movie.dto.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "MovieMapperImpl", componentModel = "spring")
public interface IMovieMapper
{
    @Mapping(source = "sceneTime", target = "sceneTime", dateFormat = "dd/MM/yyyy")
    MovieDTO toMovieDTO(Movie movie);
    @Mapping(source = "sceneTime", target = "sceneTime", dateFormat = "dd/MM/yyyy")
    Movie toMovie(MovieDTO movieDTO);

}
