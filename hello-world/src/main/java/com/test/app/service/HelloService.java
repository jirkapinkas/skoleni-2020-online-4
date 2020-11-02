package com.test.app.service;

import com.test.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private ItemRepository itemRepository;

    public String getCount() {
        return "Number of items: " + itemRepository.count();
    }

}
