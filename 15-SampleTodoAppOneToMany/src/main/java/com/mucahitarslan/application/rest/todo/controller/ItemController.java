package com.mucahitarslan.application.rest.todo.controller;

import com.mucahitarslan.application.rest.todo.data.entity.Item;
import com.mucahitarslan.application.rest.todo.dto.ItemInfoDTO;
import com.mucahitarslan.application.rest.todo.dto.ItemSaveDTO;
import com.mucahitarslan.application.rest.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final TodoService todoService;

    public ItemController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ItemSaveDTO saveItem(@RequestBody ItemSaveDTO itemSaveDTO)
    {
        return todoService.saveItem(itemSaveDTO);
    }

    @GetMapping("/all")
    public List<ItemInfoDTO> getAll()
    {
        return todoService.findAllItems();
    }
}
