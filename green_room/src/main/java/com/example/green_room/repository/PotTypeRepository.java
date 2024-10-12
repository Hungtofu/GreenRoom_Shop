package com.example.green_room.repository;

import com.example.green_room.entity.PotTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PotTypeRepository extends JpaRepository<PotTypes, Integer> {

    PotTypes findById(int id);

}
