package com.example.eshopweb.controller;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // http://localhost:8080/item
    @GetMapping
    public List<ItemDto> items() {
        return itemService.findAll(Sort.by("id"));
    }

    // http://localhost:8080/item?sort=name
    @GetMapping(params = {"sort"})
    public List<ItemDto> items(@RequestParam String sort) {
        return itemService.findAll(Sort.by(Sort.Direction.ASC, sort));
    }

    // http://localhost:8080/item?sort=name&direction=asc
    @GetMapping(params = {"sort", "direction"})
    public List<ItemDto> items(@RequestParam String sort, @RequestParam String direction) {
        return itemService.findAll(Sort.by(Sort.Direction.fromString(direction), sort));
    }

    // http://localhost:8080/item/1
    @GetMapping("/{id}")
    public Optional<ItemDto> item(@PathVariable int id) {
        return itemService.findById(id);
    }

    // http://localhost:8080/item/1
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        itemService.deleteById(id);
    }

    // http://localhost:8080/item
    @PostMapping
    public ItemDto insert(@Valid @RequestBody ItemDto itemDto) {
        itemDto.setId(0); // ID (klic) se nastavi na nulu => operace save() bude provadet insert
        return itemService.save(itemDto);
    }

    // http://localhost:8080/item/1
    @PutMapping("/{id}")
    public ItemDto update(@Valid @RequestBody ItemDto itemDto, @PathVariable int id) {
        itemDto.setId(id); // ID (klic) se natvrdo nastavi na hodnotu atributu "id"
        return itemService.save(itemDto);
    }

    // PUT vs PATCH:
    // https://stackoverflow.com/questions/28459418/use-of-put-vs-patch-methods-in-rest-api-real-life-scenarios

}
