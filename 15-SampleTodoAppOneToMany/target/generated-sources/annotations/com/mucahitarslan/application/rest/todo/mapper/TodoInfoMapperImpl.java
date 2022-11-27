package com.mucahitarslan.application.rest.todo.mapper;

import com.mucahitarslan.application.rest.todo.data.entity.Todo;
import com.mucahitarslan.application.rest.todo.dto.TodoInfoDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-27T17:38:16+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
public class TodoInfoMapperImpl implements ITodoInfoMapper {

    @Override
    public Todo toTodo(TodoInfoDTO todoInfoDTO) {
        if ( todoInfoDTO == null ) {
            return null;
        }

        Todo todo = new Todo();

        if ( todoInfoDTO.getId() != null ) {
            todo.id = todoInfoDTO.getId();
        }
        todo.title = todoInfoDTO.getTitle();
        todo.insertDateTime = todoInfoDTO.getInsertDateTime();
        todo.completed = todoInfoDTO.isCompleted();

        return todo;
    }

    @Override
    public TodoInfoDTO toTodoInfoDTO(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        TodoInfoDTO todoInfoDTO = new TodoInfoDTO();

        todoInfoDTO.setId( todo.id );
        todoInfoDTO.setTitle( todo.title );
        todoInfoDTO.setInsertDateTime( todo.insertDateTime );
        todoInfoDTO.setCompleted( todo.completed );

        return todoInfoDTO;
    }
}
