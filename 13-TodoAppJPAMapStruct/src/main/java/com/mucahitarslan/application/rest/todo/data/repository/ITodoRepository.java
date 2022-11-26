package com.mucahitarslan.application.rest.todo.data.repository;

import com.mucahitarslan.application.rest.todo.data.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo,Long>
{
    //@Query("select td from Todo td where td.completed = :completed")//select * from todosappdb where completed = :completed
    //Hibernate/JPA Query Language -> Daha yüksek seviyeli sorgulama dili
    Iterable<Todo> findByCompleted(boolean completed);

    //@Query("select td from Todo td where td.title=:title")
    Iterable<Todo> findByTitle(String title);

    Iterable<Todo> findTodosByTitleContains(String text);

    //Iterable<Todo> findByTitleOrderBy(String title);

    //@Query("select td from Todo td where td.completed=:completed and td.title=:title")
    Iterable<Todo> findByCompletedAndTitle(boolean completed, String title);

    Iterable<Todo> findByCompletedAndTitleContains(boolean completed, String title);
}
