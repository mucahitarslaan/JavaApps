package com.mucahitarslan.application.rest.todo.mapper;

import com.mucahitarslan.application.rest.todo.data.entity.Item;
import com.mucahitarslan.application.rest.todo.dto.ItemSaveDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-30T17:59:10+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class ItemSaveMapperImpl implements IItemSaveMapper {

    @Override
    public Item toItem(ItemSaveDTO itemSaveDTO) {
        if ( itemSaveDTO == null ) {
            return null;
        }

        Item item = new Item();

        item.text = itemSaveDTO.getText();

        return item;
    }

    @Override
    public ItemSaveDTO toItemSaveDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemSaveDTO itemSaveDTO = new ItemSaveDTO();

        itemSaveDTO.setText( item.text );

        return itemSaveDTO;
    }
}
