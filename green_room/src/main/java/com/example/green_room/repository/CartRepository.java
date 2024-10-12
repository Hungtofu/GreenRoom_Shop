package com.example.green_room.repository;

import com.example.green_room.entity.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Carts, Integer> {

    Carts findById(int id);

}
