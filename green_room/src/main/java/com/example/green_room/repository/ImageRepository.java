package com.example.green_room.repository;

import com.example.green_room.entity.Images;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Images, Integer> {

    Images findById(int id);

}
