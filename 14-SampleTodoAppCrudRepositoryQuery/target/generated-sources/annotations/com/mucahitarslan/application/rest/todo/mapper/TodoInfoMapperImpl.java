package com.mucahitarslan.application.rest.todo.mapper;

import com.mucahitarslan.application.rest.todo.data.entity.Todo;
import com.mucahitarslan.application.rest.todo.dto.TodoInfoDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-27T04:20:39+0300",
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
            todo.setId( todoInfoDTO.getId() );
        }
        todo.setTitle( todoInfoDTO.getTitle() );
        todo.setText( todoInfoDTO.getText() );
        todo.setInsertDateTime( todoInfoDTO.getInsertDateTime() );
        todo.setLastUpdate( todoInfoDTO.getLastUpdate() );
        todo.setCompleted( todoInfoDTO.isCompleted() );

        return todo;
    }

    @Override
    public TodoInfoDTO toTodoInfoDTO(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        TodoInfoDTO todoInfoDTO = new TodoInfoDTO();

        todoInfoDTO.setId( todo.getId() );
        todoInfoDTO.setTitle( todo.getTitle() );
        todoInfoDTO.setText( todo.getText() );
        todoInfoDTO.setInsertDateTime( todo.getInsertDateTime() );
        todoInfoDTO.setLastUpdate( todo.getLastUpdate() );
        todoInfoDTO.setCompleted( todo.isCompleted() );

        return todoInfoDTO;
    }
}
