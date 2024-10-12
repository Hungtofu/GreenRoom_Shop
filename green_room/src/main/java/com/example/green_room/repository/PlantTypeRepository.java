package com.example.green_room.repository;

import com.example.green_room.dto.PlantTypeDTO;
import com.example.green_room.entity.PlantTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantTypeRepository extends JpaRepository<PlantTypes, Integer> {

    PlantTypes findById(int id);

}
