package com.example.green_room.entity;

import jakarta.persistence.*;

@Entity(name = "cart_items")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Carts cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @Column(name = "quantity")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carts getCart() {
        return cart;
    }

    public void setCart(Carts cart) {
        this.cart = cart;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
