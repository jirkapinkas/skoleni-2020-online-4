package com.example.eshopweb.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ItemDto {

    private int id;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Min(1)
    private double price;

    private List<OrderedItemDto> orderedItems;

    private CategoryDto category;

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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
