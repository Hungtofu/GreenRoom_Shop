package com.example.green_room.repository;

import com.example.green_room.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Integer> {

    CartItems findById(int id);

}
