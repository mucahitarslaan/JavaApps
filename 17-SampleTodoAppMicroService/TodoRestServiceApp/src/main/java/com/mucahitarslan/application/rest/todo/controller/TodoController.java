package com.mucahitarslan.application.rest.todo.controller;

import com.mucahitarslan.application.rest.todo.dto.TodoInfoDTO;
import com.mucahitarslan.application.rest.todo.dto.TodoSaveDTO;
import com.mucahitarslan.application.rest.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController
{
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public List<TodoInfoDTO> findAllTodos()
    {
        return todoService.findAllTodos();
    }

    @GetMapping("/completed")
    public List<TodoInfoDTO> findTodosByCompleted(@RequestParam("comp") boolean completed)
    {
        return todoService.findTodosByCompleted(completed);
    }

    @GetMapping("/completed/title")
    public Iterable<TodoInfoDTO> findTodosByCompletedAndTitle(@RequestParam(defaultValue = "true") boolean completed, String title)
    {
        return todoService.findTodosByCompletedAndTitle(completed,title);
    }

    @GetMapping("/title")
    public Iterable<TodoInfoDTO> findTodosByTitle(String title)
    {
        return todoService.findTodosByTitle(title);
    }

    @GetMapping("/contains")
    public Iterable<TodoInfoDTO> findTodosByTitleContains(String text)
    {
        return todoService.findTodosByTitleContains(text);
    }

    @PostMapping
    public TodoInfoDTO saveTodo(@RequestBody TodoSaveDTO todoSaveDTO)
    {
        return todoService.saveTodo(todoSaveDTO);
    }

    @GetMapping("/month")
    public List<TodoInfoDTO> findTodosByMonth(int month)
    {
        return todoService.findTodosByMonth(month);
    }
}
