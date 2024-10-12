package com.example.green_room.entity;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.security.Security;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "status")
    private String status;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "orders")
    private List<OrderItems> orderItems;

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

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
}
