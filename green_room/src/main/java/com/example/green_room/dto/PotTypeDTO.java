package com.example.green_room.dto;

import com.example.green_room.entity.Products;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

public class PotTypeDTO {

    private int id;
    private String typeName;

    public PotTypeDTO(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public PotTypeDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PotTypeDTO potTypeDTO = (PotTypeDTO) o;
        return Objects.equals(id, potTypeDTO.id) &&
                Objects.equals(typeName, potTypeDTO.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName);
    }

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


}
