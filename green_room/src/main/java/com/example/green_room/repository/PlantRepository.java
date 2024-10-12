package com.example.green_room.repository;

import com.example.green_room.entity.PlantTypes;
import com.example.green_room.entity.Plants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plants, Integer> {

    Plants findById(int id);
    List<Plants> findByPlantType(PlantTypes plantTypes);
    List<Plants> findByIsRare(boolean isRare);

    @Query("SELECT p FROM plants p WHERE p.createdDate BETWEEN :startDate AND :endDate")
    List<Plants> findNewArrival(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

}
