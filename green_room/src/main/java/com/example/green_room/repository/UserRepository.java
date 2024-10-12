package com.example.green_room.repository;

import com.example.green_room.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(String email);
    Users findById(int id);

}
