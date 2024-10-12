package com.example.green_room.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity(name = "carts")
public class Carts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "cart")
    private List<CartItems> cartItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public List<CartItems> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItems> cartItems) {
        this.cartItems = cartItems;
    }
}
