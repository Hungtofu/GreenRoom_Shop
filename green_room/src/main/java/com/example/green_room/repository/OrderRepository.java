package com.example.green_room.repository;

import com.example.green_room.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    Orders findById(int id);

}
