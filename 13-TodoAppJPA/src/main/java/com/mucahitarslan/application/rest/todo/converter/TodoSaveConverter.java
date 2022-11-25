package com.mucahitarslan.application.rest.todo.converter;

import com.mucahitarslan.application.rest.todo.data.entity.Todo;
import com.mucahitarslan.application.rest.todo.dto.TodoSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoSaveConverter {
    public Todo toTodo(TodoSaveDTO todoSaveDTO)
    {
        var todo = new Todo();

        todo.setTitle(todoSaveDTO.getTitle());
        todo.setText(todoSaveDTO.getText());

        return todo;
    }

    public TodoSaveDTO toTodoSaveDTO(Todo todo)
    {
        var todoSaveDTO = new TodoSaveDTO();

        todoSaveDTO.setTitle(todo.getTitle());
        todoSaveDTO.setText(todo.getText());

        return todoSaveDTO;
    }
}
