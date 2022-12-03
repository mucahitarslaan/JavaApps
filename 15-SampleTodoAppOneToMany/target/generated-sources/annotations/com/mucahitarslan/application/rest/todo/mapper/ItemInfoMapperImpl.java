package com.mucahitarslan.application.rest.todo.mapper;

import com.mucahitarslan.application.rest.todo.data.entity.Item;
import com.mucahitarslan.application.rest.todo.dto.ItemInfoDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-03T02:49:00+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class ItemInfoMapperImpl implements IItemInfoMapper {

    @Override
    public Item toItem(ItemInfoDTO itemInfoDTO) {
        if ( itemInfoDTO == null ) {
            return null;
        }

        Item item = new Item();

        item.text = itemInfoDTO.getText();
        item.insertDateTime = itemInfoDTO.getInsertDateTime();
        item.lastUpdate = itemInfoDTO.getLastUpdate();
        item.completed = itemInfoDTO.isCompleted();

        return item;
    }

    @Override
    public ItemInfoDTO toItemInfoDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemInfoDTO itemInfoDTO = new ItemInfoDTO();

        itemInfoDTO.setText( item.text );
        itemInfoDTO.setInsertDateTime( item.insertDateTime );
        itemInfoDTO.setLastUpdate( item.lastUpdate );
        itemInfoDTO.setCompleted( item.completed );

        return itemInfoDTO;
    }
}
