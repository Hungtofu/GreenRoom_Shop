package com.example.green_room.payload.request;

import org.springframework.web.bind.annotation.RequestParam;

public class GetVariantRequest {

    private int plantId;
    private int sizeId;
    private Integer potTypeId;

    public GetVariantRequest(int plantId, int sizeId, Integer potTypeId) {
        this.plantId = plantId;
        this.sizeId = sizeId;
        this.potTypeId = potTypeId;
    }

    public GetVariantRequest(){

    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getPotTypeId() {
        return potTypeId;
    }

    public void setPotTypeId(Integer potTypeId) {
        this.potTypeId = potTypeId;
    }
}
