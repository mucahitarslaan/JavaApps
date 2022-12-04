package com.mucahitarslan.application.service.rest.movie.mapper;

import com.mucahitarslan.application.service.rest.movie.data.entity.Director;
import com.mucahitarslan.application.service.rest.movie.dto.DirectorDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-04T05:26:40+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class DirectorMapperImpl implements IDirectorMapper {

    @Override
    public Director toDirector(DirectorDTO directorDTO) {
        if ( directorDTO == null ) {
            return null;
        }

        Director director = new Director();

        director.name = directorDTO.getName();
        director.birthdate = directorDTO.getBirthdate();

        return director;
    }

    @Override
    public DirectorDTO toDirectorDTO(Director director) {
        if ( director == null ) {
            return null;
        }

        DirectorDTO directorDTO = new DirectorDTO();

        directorDTO.setName( director.name );
        directorDTO.setBirthdate( director.birthdate );

        return directorDTO;
    }
}
