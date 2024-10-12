package com.example.green_room.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class ProductDTO {

    private int id;
    private int plantId;
    private SizeDTO size;
    private PotTypeDTO potType;
    private BigDecimal price;
    private int stock;

    public ProductDTO(int id, int plantId, SizeDTO size, PotTypeDTO potType, BigDecimal price, int stock) {
        this.id = id;
        this.plantId = plantId;
        this.size = size;
        this.potType = potType;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public SizeDTO getSize() {
        return size;
    }

    public void setSize(SizeDTO size) {
        this.size = size;
    }

    public PotTypeDTO getPotType() {
        return potType;
    }

    public void setPotType(PotTypeDTO potType) {
        this.potType = potType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
