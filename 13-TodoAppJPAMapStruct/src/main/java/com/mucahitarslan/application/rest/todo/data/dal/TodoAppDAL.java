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

    public Iterable<Todo> findAllTodos()
    {
        return doWorkForRepository(todoRepository::findAll,"TodoAppDAL.findAll()");
    }

    public Iterable<Todo> findByCompletedAndTitle(boolean completed, String title)
    {
        return doWorkForRepository(() -> todoRepository.findByCompletedAndTitle(completed, title),"TodoAppDAL.findByCompletedAndTitle()");
    }

    public Iterable<Todo> findTodosByCompleted(boolean completed)
    {
        return doWorkForRepository(() -> todoRepository.findByCompleted(completed),"TodoAppDAL.findTodosByCompleted()");
    }

    public Iterable<Todo> findTodosByTitle(String title)
    {
        return doWorkForRepository(() -> todoRepository.findByTitle(title), "TodoAppDAL.findByTodosTitle()");
    }

    public Iterable<Todo> findTodosByTitleContains(String text)
    {
        return doWorkForRepository(() -> todoRepository.findTodosByTitleContains(text), "TodoAppDAL.findTodosByTitleContains()");
    }
    public Todo saveTodo(Todo todo)
    {
        return doWorkForRepository(() -> todoRepository.save(todo),"TodoAppDAL.saveTodo()");
    }

}
