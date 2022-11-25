package com.mucahitarslan.application.rest.todo.data.dal;

import com.mucahitarslan.application.rest.todo.data.entity.Todo;
import com.mucahitarslan.application.rest.todo.data.repository.ITodoRepository;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.*;

@Component
public class TodoAppDAL {
    private final ITodoRepository todoRepository;

    public TodoAppDAL(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo saveTodo(Todo todo)
    {
        return doWorkForRepository(() -> todoRepository.save(todo),"TodoAppDAL.saveTodo()");
    }
}
