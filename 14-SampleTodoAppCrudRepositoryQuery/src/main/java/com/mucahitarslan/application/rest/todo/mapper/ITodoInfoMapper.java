package com.mucahitarslan.application.rest.todo.mapper;

import com.mucahitarslan.application.rest.todo.data.entity.Todo;
import com.mucahitarslan.application.rest.todo.dto.TodoInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoInfoMapperImpl")
public interface ITodoInfoMapper
{
    Todo toTodo(TodoInfoDTO todoInfoDTO);
    TodoInfoDTO toTodoInfoDTO(Todo todo);
}
