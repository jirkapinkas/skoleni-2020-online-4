package com.example.eshopweb.service;

import com.example.eshopweb.dto.ItemDto;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDto> findAll(Sort sort);

    Optional<ItemDto> findById(int id);

    ItemDto save(ItemDto itemDto);

    void deleteById(int id);

    void clearCache();

}
