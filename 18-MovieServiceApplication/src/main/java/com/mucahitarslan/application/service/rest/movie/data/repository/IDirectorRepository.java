package com.mucahitarslan.application.service.rest.movie.data.repository;

import com.mucahitarslan.application.service.rest.movie.data.entity.Director;
import org.springframework.data.repository.CrudRepository;

public interface IDirectorRepository extends CrudRepository<Director,Long> {
}
