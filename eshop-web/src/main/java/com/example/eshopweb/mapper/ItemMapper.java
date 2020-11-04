package com.example.eshopweb.mapper;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDto entityToDto(Item item);
    List<ItemDto> entityToDto(List<Item> item);

    Item dtoToEntity(ItemDto itemDto);
    List<Item> dtoToEntity(List<ItemDto> itemDto);

}
