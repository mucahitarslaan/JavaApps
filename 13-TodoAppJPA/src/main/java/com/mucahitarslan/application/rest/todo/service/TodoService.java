package com.mucahitarslan.application.rest.todo.service;

import com.mucahitarslan.application.rest.todo.converter.TodoInfoConverter;
import com.mucahitarslan.application.rest.todo.converter.TodoSaveConverter;
import com.mucahitarslan.application.rest.todo.data.dal.TodoAppDAL;
import com.mucahitarslan.application.rest.todo.dto.TodoInfoDTO;
import com.mucahitarslan.application.rest.todo.dto.TodoSaveDTO;
import org.springframework.stereotype.Service;

import javax.swing.text.html.StyleSheet;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    private static <T,R> List<R> toList(Iterable<? extends T> iterable, boolean parallel, Function<? super T, ? extends R> function)
    {
        return StreamSupport.stream(iterable.spliterator(),parallel)
                .map(function)
                .collect(Collectors.toList());
    }
    private TodoInfoDTO saveCallback(TodoSaveDTO todoSaveDTO)
    {
        return todoInfoConverter.toTodoInfoDTO(todoAppDAL.saveTodo(todoSaveConverter.toTodo(todoSaveDTO)));
    }

    private List<TodoInfoDTO> findAllTodosCallback()
    {
        return StreamSupport.stream(todoAppDAL.findAllTodos().spliterator(),true)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed)
    {
        return StreamSupport.stream(todoAppDAL.findTodosByCompleted(completed).spliterator(),true)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByTitleCallback(String title)
    {
        return StreamSupport.stream(todoAppDAL.findTodosByTitle(title).spliterator(),false)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findByCompletedAndTitleCallback(boolean completed,String title)
    {
        return StreamSupport.stream(todoAppDAL.findByCompletedAndTitle(completed,title).spliterator(),false)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByTitleContainsCallback(String text)
    {
        return StreamSupport.stream(todoAppDAL.findTodosByTitleContains(text).spliterator(),false)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }
    public List<TodoInfoDTO> findAllTodos()
    {
        return doWorkForService(this::findAllTodosCallback, "TodoService.findAll()");
    }

    public List<TodoInfoDTO> findTodosByCompleted(boolean completed)
    {
        return doWorkForService(() -> findTodosByCompletedCallback(completed), "TodoService.findTodosByCompleted");
    }

    public List<TodoInfoDTO> findByCompletedAndTitle(boolean completed,String title)
    {
        return doWorkForService(() -> findByCompletedAndTitleCallback(completed,title), "TodoService.findByCompletedAndTitle");
    }

    public Iterable<TodoInfoDTO> findTodosByTitle(String title)
    {
        return doWorkForService(() -> findTodosByTitleCallback(title), "TodoService.findTodosByTitle()");
    }

    public Iterable<TodoInfoDTO> findTodosByTitleContains(String text)
    {
        return doWorkForService(() -> findTodosByTitleContainsCallback(text), "TodoService.findTodosByTitleContains()");
    }

    public TodoInfoDTO saveTodo(TodoSaveDTO todoSaveDTO)
    {
        return doWorkForService(() -> saveCallback(todoSaveDTO) , "TodoService.saveTodo()");
    }

}
