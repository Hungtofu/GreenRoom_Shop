package com.example.green_room.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity(name = "images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plants plant;

    @Column(name = "url")
    private String url;

    @Column(name = "created_date")
    private Timestamp createdDate;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
