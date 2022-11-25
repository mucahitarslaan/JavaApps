package com.mucahitarslan.application.rest.todo.service;

import com.mucahitarslan.application.rest.todo.converter.TodoInfoConverter;
import com.mucahitarslan.application.rest.todo.converter.TodoSaveConverter;
import com.mucahitarslan.application.rest.todo.data.dal.TodoAppDAL;
import com.mucahitarslan.application.rest.todo.dto.TodoInfoDTO;
import com.mucahitarslan.application.rest.todo.dto.TodoSaveDTO;
import org.springframework.stereotype.Service;

import static org.csystem.util.data.DatabaseUtil.*;

@Service
public class TodoService
{
    private final TodoAppDAL todoAppDAL;
    private final TodoInfoConverter todoInfoConverter;
    private final TodoSaveConverter todoSaveConverter;

    public TodoService(TodoAppDAL todoAppDAL, TodoInfoConverter todoInfoConverter, TodoSaveConverter todoSaveConverter) {
        this.todoAppDAL = todoAppDAL;
        this.todoInfoConverter = todoInfoConverter;
        this.todoSaveConverter = todoSaveConverter;
    }

    private TodoInfoDTO saveCallback(TodoSaveDTO todoSaveDTO)
    {
        return todoInfoConverter.toTodoInfoDTO(todoAppDAL.saveTodo(todoSaveConverter.toTodo(todoSaveDTO)));
    }

    public TodoInfoDTO saveTodo(TodoSaveDTO todoSaveDTO)
    {
        return doWorkForService(() -> saveCallback(todoSaveDTO) , "TodoService.saveTodo()");
    }
}
