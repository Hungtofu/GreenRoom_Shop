package com.example.green_room.dto;

import com.example.green_room.entity.CartItems;
import com.example.green_room.entity.Users;


import java.sql.Timestamp;
import java.util.Set;

public class CartDTO {

    private int id;
    private UserDTO user;
    private Timestamp createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

}
