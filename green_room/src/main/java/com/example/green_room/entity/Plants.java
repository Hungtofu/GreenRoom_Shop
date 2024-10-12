package com.example.green_room.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity(name = "plants")
public class Plants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "botanical_name")
    private String botanicalName;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "descr")
    private String description;

    @Column(name = "is_rare")
    private boolean isRare;

    @ManyToOne
    @JoinColumn(name = "type_plant")
    private PlantTypes plantType;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "plant")
    private List<Products> products;

    @OneToMany(mappedBy = "plant")
    private List<Images> images;

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
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

    public boolean isRare() {
        return isRare;
    }

    public void setRare(boolean rare) {
        isRare = rare;
    }

    public PlantTypes getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantTypes plantType) {
        this.plantType = plantType;
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
