package com.example.green_room.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "pot_types")
public class PotTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pot_type_name")
    private String typeName;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "potType")
    private List<Products> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
