package com.mucahitarslan.application.rest.todo.mapper;

import com.mucahitarslan.application.rest.todo.data.entity.Item;
import com.mucahitarslan.application.rest.todo.dto.ItemSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "ItemSaveMapperImpl", componentModel = "spring")
public interface IItemSaveMapper {
    @Mappings(@Mapping(source = "todoId",target = "todoId"))
    Item toItem(ItemSaveDTO itemSaveDTO);
    @Mappings(@Mapping(source = "todoId",target = "todoId"))
    ItemSaveDTO toItemSaveDTO(Item item);

}
