package com.example.green_room.dto;

import java.math.BigDecimal;
import java.util.List;

public class PlantListDTO {

    private int id;
    private String displayName;
    private BigDecimal priceFrom;
    private String displayImage;
    public String getDisplayImage() {
        return displayImage;
    }

    public void setDisplayImage(String displayImage) {
        this.displayImage = displayImage;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
