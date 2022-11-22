package com.mucahitarslan.application.service.rest.movie.service;

import com.mucahitarslan.application.service.rest.movie.converter.DirectorConverter;
import com.mucahitarslan.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import com.mucahitarslan.application.service.rest.movie.dto.DirectorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class DirectorService
{
    private final MovieServiceApplicationDAL movieServiceApplicationDAL;
    private final DirectorConverter directorConverter;

    public DirectorService(MovieServiceApplicationDAL movieServiceApplicationDAL, DirectorConverter directorConverter) {
        this.movieServiceApplicationDAL = movieServiceApplicationDAL;
        this.directorConverter = directorConverter;
    }

    private DirectorDTO saveDirectorCallback(DirectorDTO directorDTO)
    {
        movieServiceApplicationDAL.saveDirector(directorConverter.toDirector(directorDTO));
        return directorDTO;
    }

    private List<DirectorDTO> findAllDirectorsCallback()
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findAllDirectors().spliterator(),false)
                .map(directorConverter::toDirectorDTO)
                .collect(Collectors.toList());
    }

    public DirectorDTO saveDirector(DirectorDTO directorDTO)
    {
        return doWorkForService(() -> saveDirectorCallback(directorDTO), "MovieApplicationService.saveDirector");
    }

    public List<DirectorDTO> findAllDirectors()
    {
        return doWorkForService(this::findAllDirectorsCallback,"MovieApplicationService.findAllDirectors");
    }
}
