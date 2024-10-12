package com.example.green_room.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "sizes")
public class Sizes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "size_name")
    private String sizeName;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "size")
    private List<Products> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
