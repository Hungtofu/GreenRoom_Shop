package com.example.green_room.dto;

import com.example.green_room.entity.OrderItems;
import com.example.green_room.entity.Users;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

public class OrderDTO {

    private int id;
    private UserDTO user;
    private String status;
    private BigDecimal total;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

}
