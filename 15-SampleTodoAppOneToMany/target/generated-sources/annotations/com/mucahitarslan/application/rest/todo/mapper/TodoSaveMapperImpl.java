package com.mucahitarslan.application.rest.todo.mapper;

import com.mucahitarslan.application.rest.todo.data.entity.Todo;
import com.mucahitarslan.application.rest.todo.dto.TodoSaveDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T02:08:07+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class TodoSaveMapperImpl implements ITodoSaveMapper {

    @Override
    public Todo toTodo(TodoSaveDTO todoSaveDTO) {
        if ( todoSaveDTO == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.title = todoSaveDTO.getTitle();
        todo.description = todoSaveDTO.getDescription();

        return todo;
    }

    @Override
    public TodoSaveDTO toTodoSaveDTO(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        TodoSaveDTO todoSaveDTO = new TodoSaveDTO();

        todoSaveDTO.setTitle( todo.title );
        todoSaveDTO.setDescription( todo.description );

        return todoSaveDTO;
    }
}
