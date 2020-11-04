package com.example.eshopweb.dto;

import java.util.List;

public class ItemDto {

    private int id;

    private String name;

    private double price;

    private List<OrderedItemDto> orderedItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderedItemDto> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderedItemDto> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
