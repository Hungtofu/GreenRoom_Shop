package com.example.green_room.repository;

import com.example.green_room.entity.Roles;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {

    Roles findById(int id);

}
