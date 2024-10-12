package com.example.green_room.payload.request;

import java.math.BigDecimal;

public class ProductRequest {

    private int plantId;
    private Integer sizeId;
    private Integer potTypeId;
    private BigDecimal price;
    private int stock;

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getPotTypeId() {
        return potTypeId;
    }

    public void setPotTypeId(Integer potTypeId) {
        this.potTypeId = potTypeId;
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
}
