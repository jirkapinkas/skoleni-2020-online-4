package com.test.app.service;

import com.test.app.repository.DummyItemRepository;
import com.test.app.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class HelloService {

    private final ItemRepository itemRepository;

    public HelloService(/*@Qualifier("jdbcItemRepository")*/ ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public String getCount() {
        return "Number of items: " + itemRepository.count();
    }

}
