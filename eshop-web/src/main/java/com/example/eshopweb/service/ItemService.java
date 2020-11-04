package com.example.eshopweb.service;

import com.example.eshopweb.dto.entity.ItemDto;
import com.example.eshopweb.entity.Item;
import com.example.eshopweb.exception.NotFoundException;
import com.example.eshopweb.mapper.ItemMapper;
import com.example.eshopweb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    public List<ItemDto> findAll(Sort sort) {
        List<Item> items = itemRepository.findAll(sort);
        return itemMapper.entityToDto(items);
    }

    public Optional<ItemDto> findById(int id) {
        return itemRepository.findById(id)
                .map(itemMapper::entityToDto); // od Java 8: method reference
//                .map(item -> itemMapper.entityToDto(item)); // od Java 8: lambda
    }

    public ItemDto save(ItemDto itemDto) {
        Item item = itemMapper.dtoToEntity(itemDto);
        Item managedItem = itemRepository.save(item); // managedItem obsahuje hodnotu "id"
        return itemMapper.entityToDto(managedItem);
    }

    public void deleteById(int id) {
        if(!itemRepository.existsById(id)) {
            throw new NotFoundException("Item with id: " + id + " does not exist!");
        }
        itemRepository.deleteById(id);
    }

}
