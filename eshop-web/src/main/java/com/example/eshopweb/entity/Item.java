package com.example.eshopweb.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//@Data // Tuto anotaci u entity NIKDY NEPOUZIVAT!!!
// Tyto anotace Lomboku jsou ve spojeni s entitami bezpecne!
//@Getter
//@Setter
@Entity
//@Table(name = "item") // To zde byt nemusi!!!
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

//    @Column(name = "name") // To zde byt nemusi!!!
    private String name;

    private double price;

    private String description;

    @OneToMany(mappedBy = "item")
    private List<OrderedItem> orderedItems;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderedItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderedItem> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
