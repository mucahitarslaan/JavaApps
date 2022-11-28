package com.mucahitarslan.application.rest.todo.data.dal;

import com.mucahitarslan.application.rest.todo.data.entity.Item;
import com.mucahitarslan.application.rest.todo.data.entity.Todo;
import com.mucahitarslan.application.rest.todo.data.repository.IItemRepository;
import com.mucahitarslan.application.rest.todo.data.repository.ITodoRepository;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.*;

@Component
public class TodoAppDAL {
    private final ITodoRepository todoRepository;
    private final IItemRepository itemRepository;

    public TodoAppDAL(ITodoRepository todoRepository, IItemRepository itemRepository) {
        this.todoRepository = todoRepository;
        this.itemRepository = itemRepository;
    }

    private Item saveItemCallback(Item item) {
        var todoOpt = todoRepository.findById(item.todoId);

        if (todoOpt.isEmpty())
            throw new IllegalArgumentException("Invalid todo id");
        item.todo = todoOpt.get();

        return itemRepository.save(item);
    }
    public Iterable<Todo> findAllTodos()
    {
        return doWorkForRepository(todoRepository::findAll,"TodoAppDAL.findAll()");
    }

    public Iterable<Todo> findTodosByCompletedAndTitle(boolean completed, String title)
    {
        return doWorkForRepository(() -> todoRepository.findTodosByCompletedAndTitle(completed, title),"TodoAppDAL.findByCompletedAndTitle()");
    }

    public Iterable<Todo> findTodosByCompleted(boolean completed)
    {
        return doWorkForRepository(() -> todoRepository.findTodosByCompleted(completed),"TodoAppDAL.findTodosByCompleted()");
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

    public Iterable<Todo> findTodosByMonth(int month)
    {
        return doWorkForRepository(() -> todoRepository.findTodosByMonth(month),"TodoAppDAL.findTodosByMonth");
    }

    public Item saveItem(Item item)
    {
        return doWorkForRepository(() -> saveItemCallback(item),"TodoAppDAL.saveItem()");
    }
}