package com.example.green_room.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity(name = "types_plant")
public class PlantTypes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "plantType")
    private List<Plants> plants;

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

    public List<Plants> getPlants() {
        return plants;
    }

    public void setPlants(List<Plants> plants) {
        this.plants = plants;
    }
}
