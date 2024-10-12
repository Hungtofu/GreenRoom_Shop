package com.example.green_room.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plants plant;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Sizes size;

    @ManyToOne
    @JoinColumn(name = "pot_type_id")
    private PotTypes potType;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "product")
    private List<CartItems> cartItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Plants getPlant() {
        return plant;
    }

    public void setPlant(Plants plant) {
        this.plant = plant;
    }

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public PotTypes getPotType() {
        return potType;
    }

    public void setPotType(PotTypes potType) {
        this.potType = potType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
