package com.mucahitarslan.application.rest.todo.service;

import com.mucahitarslan.application.rest.todo.data.dal.TodoAppDAL;
import com.mucahitarslan.application.rest.todo.data.entity.Item;
import com.mucahitarslan.application.rest.todo.dto.ItemInfoDTO;
import com.mucahitarslan.application.rest.todo.dto.ItemSaveDTO;
import com.mucahitarslan.application.rest.todo.dto.TodoInfoDTO;
import com.mucahitarslan.application.rest.todo.dto.TodoSaveDTO;
import com.mucahitarslan.application.rest.todo.mapper.IItemInfoMapper;
import com.mucahitarslan.application.rest.todo.mapper.IItemSaveMapper;
import com.mucahitarslan.application.rest.todo.mapper.ITodoInfoMapper;
import com.mucahitarslan.application.rest.todo.mapper.ITodoSaveMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class TodoService
{
    private final TodoAppDAL todoAppDAL;
    private final ITodoInfoMapper todoInfoMapper;
    private final ITodoSaveMapper todoSaveMapper;
    private final IItemInfoMapper itemInfoMapper;
    private final IItemSaveMapper itemSaveMapper;

    public TodoService(TodoAppDAL todoAppDAL, ITodoInfoMapper todoInfoMapper, ITodoSaveMapper todoSaveMapper, IItemInfoMapper itemInfoMapper, IItemSaveMapper itemSaveMapper) {
        this.todoAppDAL = todoAppDAL;
        this.todoInfoMapper = todoInfoMapper;
        this.todoSaveMapper = todoSaveMapper;
        this.itemInfoMapper = itemInfoMapper;
        this.itemSaveMapper = itemSaveMapper;
    }

    //Kod tekrarını azaltmak için böyle bir metot yazılabilir.
    private static <T,R> List<R> convertToList(Iterable<? extends T> iterable, boolean parallel, Function<? super T, ? extends R> function)
    {
        return StreamSupport.stream(iterable.spliterator(),parallel)
                .map(function)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findAllTodosCallback()
    {
        return convertToList(todoAppDAL.findAllTodos(),true, todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed)
    {
        return convertToList(todoAppDAL.findTodosByCompleted(completed),true, todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByTitleCallback(String title)
    {
        return convertToList(todoAppDAL.findTodosByTitle(title),false, todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByCompletedAndTitleCallback(boolean completed, String title)
    {
        return convertToList(todoAppDAL.findTodosByCompletedAndTitle(completed,title),false, todoInfoMapper::toTodoInfoDTO);
//        return StreamSupport.stream(todoAppDAL.findByCompletedAndTitle(completed,title).spliterator(),false)
//                .map(todoInfoConverter::toTodoInfoDTO)
//                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByMonthCallback(int month)
    {
        return convertToList(todoAppDAL.findTodosByMonth(month),false,todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByTitleContainsCallback(String text)
    {
        return convertToList(todoAppDAL.findTodosByTitleContains(text), false, todoInfoMapper::toTodoInfoDTO);
//        return StreamSupport.stream(todoAppDAL.findTodosByTitleContains(text).spliterator(),false)
//                .map(todoInfoConverter::toTodoInfoDTO)
//                .collect(Collectors.toList());
    }

    public List<TodoInfoDTO> findAllTodos()
    {
        return doWorkForService(this::findAllTodosCallback, "TodoService.findAll()");
    }


    private TodoInfoDTO saveCallback(TodoSaveDTO todoSaveDTO)
    {
        return todoInfoMapper.toTodoInfoDTO(todoAppDAL.saveTodo(todoSaveMapper.toTodo(todoSaveDTO)));
    }

    private ItemSaveDTO saveItemCallback(ItemSaveDTO itemSaveDTO)
    {
        return itemSaveMapper.toItemSaveDTO(todoAppDAL.saveItem(itemSaveDTO));
    }

    public List<TodoInfoDTO> findTodosByCompleted(boolean completed)
    {
        return doWorkForService(() -> findTodosByCompletedCallback(completed), "TodoService.findTodosByCompleted");
    }

    public List<TodoInfoDTO> findTodosByCompletedAndTitle(boolean completed, String title)
    {
        return doWorkForService(() -> findTodosByCompletedAndTitleCallback(completed,title), "TodoService.findByCompletedAndTitle");
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

    public List<TodoInfoDTO> findTodosByMonth(int month)
    {
        return doWorkForService(() -> findTodosByMonthCallback(month),"TodoService.findTodosByMonth()");
    }

    public ItemSaveDTO saveItem(ItemSaveDTO itemSaveDTO)
    {
        return doWorkForService(() -> saveItemCallback(itemSaveDTO), "TodoService.saveItem()");
    }

    public List<ItemInfoDTO> findAllItemsCallback()
    {
        return convertToList(todoAppDAL.findAllItems(),true,itemInfoMapper::toItemInfoDTO);
    }

    public List<ItemInfoDTO> findAllItems()
    {
        return doWorkForService(this::findAllItemsCallback, "TodoService.findAll()");
    }
}
//
//class App{
//    //numberdan türeyenleri T extends Number ->>>>> T yerine gelebilir.
//
//    public static void main(String[] args)
//    {
//        RamazanAbi<Integer> integerRamazanAbi = new RamazanAbi<>();
//
//
//    }
//}
//class RamazanAbi<T extends Number>{
//
//
//}
//class Xss{
//    List<T super Number>
//}