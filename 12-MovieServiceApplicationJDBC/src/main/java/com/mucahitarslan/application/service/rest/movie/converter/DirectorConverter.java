package com.mucahitarslan.application.service.rest.movie.converter;

import com.mucahitarslan.application.service.rest.movie.data.entity.Director;
import com.mucahitarslan.application.service.rest.movie.dto.DirectorDTO;
import org.springframework.stereotype.Component;

@Component
public class DirectorConverter
{
    public DirectorDTO toDirectorDTO(Director director)
    {
        var directorDto = new DirectorDTO();

        directorDto.setName(director.getName());
        directorDto.setBirthdate(director.getBirthdate());

        return directorDto;
    }

    public Director toDirector(DirectorDTO directorDTO)
    {
        var director = new Director();

        director.setName(directorDTO.getName());
        director.setBirthdate(directorDTO.getBirthdate());

        return director;
    }
}
