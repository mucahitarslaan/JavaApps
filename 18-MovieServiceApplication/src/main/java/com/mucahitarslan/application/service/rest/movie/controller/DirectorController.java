package com.mucahitarslan.application.service.rest.movie.controller;

import com.mucahitarslan.application.service.rest.movie.dto.DirectorDTO;
import com.mucahitarslan.application.service.rest.movie.service.DirectorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.csystem.util.exception.ExceptionUtil.subscribe;

@RestController
@RequestMapping("api/director")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/all")
    public List<DirectorDTO> findAllDirectors()
    {
        return  subscribe(directorService::findAllDirectors, ex -> new ArrayList<>());
    }

    @PostMapping("/save")
    public DirectorDTO saveDirector(@RequestBody DirectorDTO directorDTO)
    {
        return directorService.saveDirector(directorDTO);
    }
}
