package com.example.green_room.dto;

import com.example.green_room.entity.Plants;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

public class PlantTypeDTO {

    private int id;
    private String typeName;
    private Timestamp createdDate;

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

}
