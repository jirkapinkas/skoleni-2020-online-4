package com.example.eshopweb.service;

import com.example.eshopweb.dto.entity.ItemDto;
import com.example.eshopweb.entity.Item;
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

    public List<ItemDto> findAll() {
        List<Item> items = itemRepository.findAll(Sort.by("id"));
        return itemMapper.entityToDto(items);
    }

    public Optional<ItemDto> findById(int id) {
        return itemRepository.findById(id)
                .map(itemMapper::entityToDto);
    }

}
