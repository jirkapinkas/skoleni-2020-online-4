package com.example.eshopweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "ordereditem")
public class OrderedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordereditemid")
    private int id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
