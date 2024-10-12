package com.example.green_room.dto;

import com.example.green_room.entity.Users;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

public class RoleDTO {

    private int id;
    private String roleName;
    private Timestamp createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

}
