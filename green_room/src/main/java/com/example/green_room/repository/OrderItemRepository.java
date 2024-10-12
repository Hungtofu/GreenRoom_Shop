package com.example.green_room.repository;

import com.example.green_room.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Integer> {

    OrderItems findById(int id);

}
