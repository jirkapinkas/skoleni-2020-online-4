package com.example.eshopweb.controller;

import com.example.eshopweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/clearCaches") // opet ... lepsi by bylo @PostMapping
    public void clearCaches() {
        itemService.clearCache();
    }

}
