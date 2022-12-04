package com.mucahitarslan.application.service.rest.movie.service;

import com.mucahitarslan.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import com.mucahitarslan.application.service.rest.movie.dto.DirectorDTO;
import com.mucahitarslan.application.service.rest.movie.mapper.IDirectorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class DirectorService
{
    private final MovieServiceApplicationDAL movieServiceApplicationDAL;
    private final IDirectorMapper directorMapper;

    public DirectorService(MovieServiceApplicationDAL movieServiceApplicationDAL, IDirectorMapper directorMapper) {
        this.movieServiceApplicationDAL = movieServiceApplicationDAL;
        this.directorMapper = directorMapper;
    }

    private DirectorDTO saveDirectorCallback(DirectorDTO directorDTO)
    {
        movieServiceApplicationDAL.saveDirector(directorMapper.toDirector(directorDTO));
        return directorDTO;
    }

    private List<DirectorDTO> findAllDirectorsCallback()
    {
        return StreamSupport.stream(movieServiceApplicationDAL.findAllDirectors().spliterator(),false)
                .map(directorMapper::toDirectorDTO)
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
