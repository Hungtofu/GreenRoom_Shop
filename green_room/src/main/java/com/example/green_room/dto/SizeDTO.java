package com.example.green_room.dto;

import com.example.green_room.entity.Products;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

public class SizeDTO {

    private int id;
    private String sizeName;

    public SizeDTO(int id, String sizeName) {
        this.id = id;
        this.sizeName = sizeName;
    }

    public SizeDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizeDTO sizeDTO = (SizeDTO) o;
        return Objects.equals(id, sizeDTO.id) &&
                Objects.equals(sizeName, sizeDTO.sizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sizeName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }


}
