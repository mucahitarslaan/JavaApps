package com.mucahitarslan.application.rest.todo.data.repository;

import com.mucahitarslan.application.rest.todo.data.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface IItemRepository extends CrudRepository<Item,Long> {
}
