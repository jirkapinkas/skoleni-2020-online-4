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
@NamedEntityGraph(
        name = Item.GRAPH_CATEGORY,
        attributeNodes = {
                @NamedAttributeNode(value = "category")
        })
public class Item {

    public static final String GRAPH_CATEGORY = "graph.Item.category";

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

    // POZOR! VYCHOZI NASTAVENI VAZBY JE: fetch = FetchType.EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Item() {
    }

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                "}'";
    }
}
