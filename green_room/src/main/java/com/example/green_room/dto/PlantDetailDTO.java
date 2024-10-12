package com.example.green_room.dto;

import com.example.green_room.entity.Products;

import java.util.List;
import java.util.Set;

public class PlantDetailDTO {

    private int id;
    private String displayName;
    private String botanicalName;
    private String commonName;
    private String description;
    private Set<SizeDTO> sizeVariant;
    private Set<PotTypeDTO> potTypeVariant;
    private List<String> images;

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

    public String getBotanicalName() {
        return botanicalName;
    }

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SizeDTO> getSizeVariant() {
        return sizeVariant;
    }

    public void setSizeVariant(Set<SizeDTO> sizeVariant) {
        this.sizeVariant = sizeVariant;
    }

    public Set<PotTypeDTO> getPotTypeVariant() {
        return potTypeVariant;
    }

    public void setPotTypeVariant(Set<PotTypeDTO> potTypeVariant) {
        this.potTypeVariant = potTypeVariant;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
