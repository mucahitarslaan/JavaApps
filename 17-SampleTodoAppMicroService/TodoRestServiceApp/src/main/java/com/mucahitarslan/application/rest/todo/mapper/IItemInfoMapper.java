package com.mucahitarslan.application.rest.todo.mapper;

import com.mucahitarslan.application.rest.todo.data.entity.Item;
import com.mucahitarslan.application.rest.todo.dto.ItemInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ItemInfoMapperImpl", componentModel = "spring")
public interface IItemInfoMapper {
    Item toItem(ItemInfoDTO itemInfoDTO);
    ItemInfoDTO toItemInfoDTO(Item item);
}
