package com.example.eshopweb.service;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.entity.Item;
import com.example.eshopweb.exception.DeleteException;
import com.example.eshopweb.exception.NotFoundException;
import com.example.eshopweb.mapper.ItemMapper;
import com.example.eshopweb.repository.ItemRepository;
import org.hibernate.annotations.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    // POZOR NA KOMBINOVANI @Transactional A @Cache anotaci!!!
    // https://www.foreach.be/blog/spring-cache-annotations-some-tips-tricks
    @Cacheable("items")
    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> findAll(Sort sort) {
        List<Item> items = itemRepository.findAll(sort);
//        List<Item> items = itemRepository.findAllFetchCategory(sort);
        return itemMapper.entityToDto(items);
    }

    // POZOR NA KOMBINOVANI @Transactional A @Cache anotaci!!!
    // https://www.foreach.be/blog/spring-cache-annotations-some-tips-tricks
    @Cacheable(cacheNames = "item", key = "#id")
    @Override
    @Transactional(readOnly = true)
    public Optional<ItemDto> findById(int id) {
        return itemRepository.findById(id)
//        return itemRepository.findByIdFetchCategory(id)
                .map(itemMapper::entityToDto); // od Java 8: method reference
//                .map(item -> itemMapper.entityToDto(item)); // od Java 8: lambda
    }

    // POZOR NA KOMBINOVANI @Transactional A @Cache anotaci!!!
    // https://www.foreach.be/blog/spring-cache-annotations-some-tips-tricks
    @Caching(evict = {
            @CacheEvict(cacheNames = "items", allEntries = true),
            @CacheEvict(cacheNames = "item", key = "#itemDto.id")
    })
    @Override
    @Transactional
    public ItemDto save(ItemDto itemDto) {
        Item item = itemMapper.dtoToEntity(itemDto);
        Item managedItem = itemRepository.save(item); // managedItem obsahuje hodnotu "id"
        return itemMapper.entityToDto(managedItem);
    }

    // POZOR NA KOMBINOVANI @Transactional A @Cache anotaci!!!
    // https://www.foreach.be/blog/spring-cache-annotations-some-tips-tricks
    @Caching(evict = {
            @CacheEvict(cacheNames = "items", allEntries = true),
            @CacheEvict(cacheNames = "item", key = "#id")
    })
    @Override
    @Transactional
    public void deleteById(int id) {
        if(!itemRepository.existsById(id)) {
            throw new NotFoundException("Item with id: " + id + " does not exist!");
        }
        try {
            itemRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteException("Couldn't delete item with id: " + id);
        }
    }

    @Override
    @CacheEvict(cacheNames = {"items", "item"}, allEntries = true)
    public void clearCache() {
        log.info("caches: items, item CLEARED!");
    }

}
