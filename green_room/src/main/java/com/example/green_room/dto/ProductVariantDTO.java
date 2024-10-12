package com.example.green_room.dto;

import java.math.BigDecimal;

public class ProductVariantDTO {

    private Integer id;
    private BigDecimal price;
    private Integer stock;
    private boolean isAvailable;

    public ProductVariantDTO(Integer id, BigDecimal price, Integer stock, boolean isAvailable) {
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.isAvailable = isAvailable;
    }

    public ProductVariantDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
