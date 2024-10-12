package com.example.green_room.repository;

import com.example.green_room.entity.Plants;
import com.example.green_room.entity.PotTypes;
import com.example.green_room.entity.Products;
import com.example.green_room.entity.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

    Products findById(int id);
    Products findByPlantAndSizeAndPotType(Plants plant, Sizes size, PotTypes potType);
    Products findByPlantAndSize(Plants plant, Sizes size);
}
