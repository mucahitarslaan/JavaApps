package com.mucahitarslan.application.rest.todo.data.repository;

import com.mucahitarslan.application.rest.todo.data.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo,Long>
{

}
