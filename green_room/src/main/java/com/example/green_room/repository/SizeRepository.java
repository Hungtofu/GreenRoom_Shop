package com.example.green_room.repository;

import com.example.green_room.entity.Products;
import com.example.green_room.entity.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Sizes, Integer> {

    Sizes findById(int id);


}
